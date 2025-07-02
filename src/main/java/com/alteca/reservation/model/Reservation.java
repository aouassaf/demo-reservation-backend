package com.alteca.reservation.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String salle;
    private String nomUtilisateur;
    private LocalDateTime debut;
    private LocalDateTime fin;

    // Getters
    public Long getId() {
        return id;
    }

    public String getSalle() {
        return salle;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public LocalDateTime getDebut() {
        return debut;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public void setDebut(LocalDateTime debut) {
        this.debut = debut;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }
}
