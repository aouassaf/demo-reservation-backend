package com.alteca.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alteca.reservation.model.Salle;

public interface SalleRepository extends JpaRepository<Salle, Long> {
}
