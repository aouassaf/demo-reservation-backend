package com.alteca.reservation.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alteca.reservation.dto.AvailabilityResponse;
import com.alteca.reservation.model.Salle;
import com.alteca.reservation.service.SalleService;

@RestController
@RequestMapping("/api/salles")
@CrossOrigin
public class SalleController {

    private final SalleService service;

    public SalleController(SalleService service) {
        this.service = service;
    }

    @GetMapping
    public List<Salle> getAllSalles() {
        return service.getAll();
    }

    @GetMapping("/check-availability")
    public AvailabilityResponse checkAvailability(
            @RequestParam String salle,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime debut,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fin) {

        return service.checkAvailability(salle, debut, fin);
    }
}
