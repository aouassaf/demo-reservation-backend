package com.alteca.reservation.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alteca.reservation.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findBySalleAndDebutLessThanAndFinGreaterThan(
            String salle, LocalDateTime fin, LocalDateTime debut);

    List<Reservation> findBySalle(String salle);

    List<Reservation> findByNomUtilisateur(String nomUtilisateur);

    List<Reservation> findByDebutAfter(LocalDateTime date);
    
}