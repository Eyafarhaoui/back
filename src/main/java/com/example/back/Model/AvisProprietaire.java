package com.example.back.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "avis_Proprietaire")
public class AvisProprietaire { 

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "avisProprietaire_seq_gen")
    @SequenceGenerator(name = "avisProprietaire_gen", sequenceName = "avisProprietaire_seq", allocationSize = 1)
    private Long id;

    private String contenu;
    private int note;

    @ManyToOne
    @JoinColumn(name = "proprietaire_id", referencedColumnName = "id")
    private Proprietaire proprietaire;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private client client;

    @ManyToOne
    @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    private Reservation reservation;

    private LocalDateTime dateAvis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public Proprietaire getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }

    public client getClient() {
        return client;
    }

    public void setClient(client client) {
        this.client = client;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public LocalDateTime getDateAvis() {
        return dateAvis;
    }

    public void setDateAvis(LocalDateTime dateAvis) {
        this.dateAvis = dateAvis;
    }


    

    
}
