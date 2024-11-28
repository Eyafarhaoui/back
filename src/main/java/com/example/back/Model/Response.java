package com.example.back.Model;

import jakarta.persistence.*;

@Entity
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "response_seq_gen")
    @SequenceGenerator(name = "response_seq_gen", sequenceName = "response_seq", allocationSize = 1)
    private Long idResponse;
    

    private Long idPublication;
    private Long idClient;
    private Long idProprietaire;
    private String responsecontenu;

    public Long getIdPublication() {
        return idPublication;
    }

    public void setIdPublication(Long idPublication) {
        this.idPublication = idPublication;
    }




    // Getters et Setters
    public Long getIdResponse() {
        return idResponse;
    }

    public void setIdResponse(Long idResponse) {
        this.idResponse = idResponse;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Long getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(Long idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    public String getResponsecontenu() {
        return responsecontenu;
    }

    public void setResponsecontenu(String responsecontenu) {
        this.responsecontenu = responsecontenu;
    }
}