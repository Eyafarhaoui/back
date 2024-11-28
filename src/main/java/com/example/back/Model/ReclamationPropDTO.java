package com.example.back.Model;

public class ReclamationPropDTO {

    private String nomProprietaire;
    private String contenuReclamation;
    private String telephoneProprietaire;
    private String emailProprietaire;

    // Constructeur
    public ReclamationPropDTO(String nomProprietaire, String contenuReclamation, String telephoneProprietaire, String emailProprietaire) {
        this.nomProprietaire = nomProprietaire;
        this.contenuReclamation = contenuReclamation;
        this.telephoneProprietaire = telephoneProprietaire;
        this.emailProprietaire = emailProprietaire;
    }

    // Getters et Setters
    public String getNomProprietaire() {
        return nomProprietaire;
    }

    public void setNomProprietaire(String nomProprietaire) {
        this.nomProprietaire = nomProprietaire;
    }

    public String getContenuReclamation() {
        return contenuReclamation;
    }

    public void setContenuReclamation(String contenuReclamation) {
        this.contenuReclamation = contenuReclamation;
    }

    public String getTelephoneProprietaire() {
        return telephoneProprietaire;
    }

    public void setTelephoneProprietaire(String telephoneProprietaire) {
        this.telephoneProprietaire = telephoneProprietaire;
    }

    public String getEmailProprietaire() {
        return emailProprietaire;
    }

    public void setEmailProprietaire(String emailProprietaire) {
        this.emailProprietaire = emailProprietaire;
    }
}

