# Système de Réservation de Salles - Backend

Ce projet est une API REST développée avec Spring Boot pour gérer un système de réservation de salles.

## Technologies utilisées

- Java 17
- Spring Boot 3.5.0
- Spring Data JPA
- PostgreSQL
- Maven

## Structure du projet

Le projet est organisé selon l'architecture MVC (Modèle-Vue-Contrôleur) :

- **Modèles** ([`com.alteca.reservation.model`](src/main/java/com/alteca/reservation/model)) : Entités JPA représentant les données
  - [`Salle`](src/main/java/com/alteca/reservation/model/Salle.java) : Représente une salle avec ses caractéristiques
  - [`Reservation`](src/main/java/com/alteca/reservation/model/Reservation.java) : Représente une réservation de salle

- **Repositories** ([`com.alteca.reservation.repository`](src/main/java/com/alteca/reservation/repository)) : Interfaces d'accès aux données
  - [`SalleRepository`](src/main/java/com/alteca/reservation/repository/SalleRepository.java) : Gestion des salles
  - [`ReservationRepository`](src/main/java/com/alteca/reservation/repository/ReservationRepository.java) : Gestion des réservations

- **Services** ([`com.alteca.reservation.service`](src/main/java/com/alteca/reservation/service)) : Logique métier
  - [`SalleService`](src/main/java/com/alteca/reservation/service/SalleService.java) : Opérations sur les salles
  - [`ReservationService`](src/main/java/com/alteca/reservation/service/ReservationService.java) : Opérations sur les réservations

- **Contrôleurs** ([`com.alteca.reservation.controller`](src/main/java/com/alteca/reservation/controller)) : Points d'entrée de l'API
  - [`SalleController`](src/main/java/com/alteca/reservation/controller/SalleController.java) : API des salles
  - [`ReservationController`](src/main/java/com/alteca/reservation/controller/ReservationController.java) : API des réservations

- **DTOs** ([`com.alteca.reservation.dto`](src/main/java/com/alteca/reservation/dto)) : Objets de transfert de données
  - [`AvailabilityResponse`](src/main/java/com/alteca/reservation/dto/AvailabilityResponse.java) : Réponse pour vérifier la disponibilité d'une salle

## Fonctionnalités principales

1. **Gestion des salles**
   - Récupération de toutes les salles
   - Vérification de la disponibilité d'une salle

2. **Gestion des réservations**
   - Création, modification et suppression de réservations
   - Recherche de réservations par salle, utilisateur ou date
   - Vérification des conflits entre réservations

## Configuration

La configuration de l'application se trouve dans le fichier [`application.properties`](src/main/resources/application.properties). Ce fichier contient les paramètres de connexion à la base de données PostgreSQL et d'autres configurations.

## Installation et démarrage

### Prérequis
- Java 17 ou supérieur
- PostgreSQL
- Maven (ou utiliser le wrapper Maven inclus)

### Étapes d'installation

1. Cloner le dépôt
2. Configurer la base de données PostgreSQL