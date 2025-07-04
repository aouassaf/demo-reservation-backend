package com.alteca.reservation.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.alteca.reservation.model.Reservation;
import com.alteca.reservation.service.ReservationService;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin
public class ReservationController {

    private final ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Reservation> getAll() {
        return service.getAllReservations();
    }

    @PostMapping
    public Reservation create(@RequestBody Reservation r) {
        try {
            return service.createReservation(r);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Reservation update(@PathVariable Long id, @RequestBody Reservation r) {
        return service.updateReservation(id, r);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteReservation(id);
    }

    @GetMapping("/salle")
    public List<Reservation> getBySalle(@RequestParam String salle) {
        return service.getBySalle(salle);
    }

    @GetMapping("/utilisateur")
    public List<Reservation> getByUtilisateur(@RequestParam String nom) {
        return service.getByUtilisateur(nom);
    }

    @GetMapping("/date")
    public List<Reservation> getAfterDate(@RequestParam String date) {
        LocalDateTime d = LocalDateTime.of(date);
        return service.getByDate(d);
    }

}
