package com.alteca.reservation.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alteca.reservation.model.Reservation;
import com.alteca.reservation.repository.ReservationRepository;

@Service
public class ReservationService {

    private final ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public List<Reservation> getAllReservations() {
        return repository.findAll();
    }

    public List<Reservation> getBySalle(String salle) {
        return repository.findBySalle(salle);
    }

    public List<Reservation> getByUtilisateur(String nomUtilisateur) {
        return repository.findByNomUtilisateur(nomUtilisateur);
    }

    public List<Reservation> getByDate(LocalDateTime date) {
        return repository.findByDebutAfter(date);
    }

    public Optional<Reservation> getReservationById(Long id) {
        return repository.findById(id);
    }

    public Reservation createReservation(Reservation reservation) {
        List<Reservation> conflits = repository.findBySalleAndDebutLessThanAndFinGreaterThan(
                reservation.getSalle(), reservation.getFin(), reservation.getDebut());

        if (!conflits.isEmpty()) {
            throw new RuntimeException("Conflit de réservation pour cette salle et ce créneau.");
        }

        return repository.save(reservation);
    }

    public Reservation updateReservation(Long id, Reservation newRes) {
        return repository.findById(id)
                .map(r -> {
                    r.setNomUtilisateur(newRes.getNomUtilisateur());
                    r.setSalle(newRes.getSalle());
                    r.setDebut(newRes.getDebut());
                    r.setFin(newRes.getFin());
                    return repository.save(r);
                }).orElseThrow();
    }

    public void deleteReservation(Long id) {
        repository.deleteById(id);
    }
}
