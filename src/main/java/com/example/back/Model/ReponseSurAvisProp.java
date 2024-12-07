package com.example.back.Model;

import java.time.LocalDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ReponseSurAvisProp")
public class ReponseSurAvisProp {
   
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "responseavis_seq_gen")
    @SequenceGenerator(name = "responseavis_seq_gen", sequenceName = "responseavis_seq", allocationSize = 1)
    private Long id;

   
    @ManyToOne
    @JoinColumn(name = "proprietaire_id", referencedColumnName = "id")
    private Proprietaire proprietaire;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private client client; // Association avec l'entité Client
    private String commentaire;
    private String contenuAvis;
    


  

   

    public Proprietaire getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }

    

    /*@ManyToOne
    @JoinColumn(name = "AVIS_ID", referencedColumnName = "id")
    private AvisProprietaire avis; // Association avec l'entité AvisProprietaire*/

    

   

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getContenuAvis() {
        return contenuAvis;
    }

    public void setContenuAvis(String contenuAvis) {
        this.contenuAvis = contenuAvis;
    }

    /*public AvisProprietaire getAvis() {
        return avis;
    }

    public void setAvis(AvisProprietaire avis) {
        this.avis = avis;
    }*/

    public client getClient() {
        return client;
    }

    public void setClient(client client) {
        this.client = client;
    }
}