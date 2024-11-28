package com.example.back.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.back.Model.Disponibilite;
import com.example.back.Model.Reservation;
import com.example.back.Model.Voiture;
import com.example.back.repository.DisponibiliteRepository;
import com.example.back.repository.ReservationRepository;
import com.example.back.repository.VoitureRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private VoitureRepository voitureRepository;
    
    @Autowired
    private DisponibiliteRepository disponibiliteRepository;

    public Reservation createReservation(Reservation reservation) {
        // Save the reservation
        Reservation createdReservation = reservationRepository.save(reservation);
    
        
        // Retrieve the vehicle and its availability slots
        Voiture voiture = voitureRepository.findById(reservation.getVoitureId())
                .orElseThrow(() -> new RuntimeException("Voiture non trouvée"));
    
                voiture.setEtat("reservee");
                voitureRepository.save(voiture);
        
        LocalDate dateDebutReservation = reservation.getDateDebut();
        LocalDate dateFinReservation = reservation.getDateFin();
    
        List<Disponibilite> disponibilites = voiture.getDisponibilites();
        List<Disponibilite> nouvellesDisponibilites = new ArrayList<>();
        
    
        for (Disponibilite dispo : disponibilites) {
            LocalDate dispoDebut = dispo.getDateDebutDisponibilite();
            LocalDate dispoFin = dispo.getDateFinDisponibilite();
    
            // Case 1: Reservation is at the beginning of availability
            if (dateDebutReservation.equals(dispoDebut) && dateFinReservation.isBefore(dispoFin)) {
                dispo.setDateDebutDisponibilite(dateFinReservation.plusDays(1));
                nouvellesDisponibilites.add(dispo);
    
            // Case 2: Reservation is at the end of availability
            } else if (dateFinReservation.equals(dispoFin) && dateDebutReservation.isAfter(dispoDebut)) {
                dispo.setDateFinDisponibilite(dateDebutReservation.minusDays(1));
                nouvellesDisponibilites.add(dispo);
    
            // Case 3: Reservation is in the middle of availability (splitting)
            } else if (dateDebutReservation.isAfter(dispoDebut) && dateFinReservation.isBefore(dispoFin)) {
                // Create two new availability slots before and after the reservation
                Disponibilite avant = new Disponibilite();
                avant.setDateDebutDisponibilite(dispoDebut);
                avant.setDateFinDisponibilite(dateDebutReservation.minusDays(1));
                avant.setVoiture(voiture);
                nouvellesDisponibilites.add(avant);
    
                Disponibilite apres = new Disponibilite();
                apres.setDateDebutDisponibilite(dateFinReservation.plusDays(1));
                apres.setDateFinDisponibilite(dispoFin);
                apres.setVoiture(voiture);
                nouvellesDisponibilites.add(apres);
    
                // Remove the original availability from the database
                disponibiliteRepository.delete(dispo);
    
            // Other cases: No overlap with the reservation, keep the original availability
            } else {
                nouvellesDisponibilites.add(dispo);
            }
        }
    
        // Update the vehicle's availability with the modified list
        voiture.setDisponibilites(nouvellesDisponibilites);
        voitureRepository.save(voiture);
    
        return createdReservation;
    }

    public List<Reservation> getReservationsByClientId(Long clientId) {
        return reservationRepository.findByClientId(clientId);
    }
    public List<Reservation> findReservationsByProprietaireId(Long proprietaireId) {
        return reservationRepository.findByProprietaireId(proprietaireId);
    }
}    
