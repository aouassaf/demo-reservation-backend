package com.alteca.reservation.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alteca.reservation.dto.AvailabilityResponse;
import com.alteca.reservation.model.Reservation;
import com.alteca.reservation.model.Salle;
import com.alteca.reservation.repository.ReservationRepository;
import com.alteca.reservation.repository.SalleRepository;

@Service
public class SalleService {
    private final SalleRepository repository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public SalleService(SalleRepository repository, ReservationRepository reservationRepository) {
        this.repository = repository;
        this.reservationRepository = reservationRepository;
    }

    public List<Salle> getAll() {
        return repository.findAll();
    }

    /**
     * Vérifie la disponibilité d'une salle pour un créneau donné.
     * 
     * @param salle Nom de la salle
     * @param debut Début du créneau
     * @param fin   Fin du créneau
     * @return true si la salle est disponible, false sinon
     */
    public AvailabilityResponse checkAvailability(String salle, LocalDateTime debut, LocalDateTime fin) {
        List<Reservation> reservations = reservationRepository.findBySalle(salle);
        LocalDateTime now = LocalDateTime.now();
        System.out.println("🕒 Now = " + now);

        for (Reservation r : reservations) {
            System.out.println("➡️ Réservation: " + r.getDebut() + " -> " + r.getFin());
            if (now.isBefore(r.getFin()) && now.isAfter(r.getDebut())) {
                System.out.println("❌ Salle occupée jusqu’à " + r.getFin());
                return new AvailabilityResponse(false, r.getFin());
            }
        }

        System.out.println("✅ Salle libre");
        return new AvailabilityResponse(true, null);
    }
     public List<Reservation> getReservationsBySalleAndDate(String salle, LocalDateTime date) {
        List<Reservation> reservations = reservationRepository.findBySalle(salle);
        return reservations.stream()
                .filter(r -> (r.getDebut().toLocalDate().equals(date.toLocalDate())))
                .toList();
    }

}
