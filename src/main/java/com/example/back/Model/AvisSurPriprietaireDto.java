package com.example.back.Model;

import java.time.LocalDateTime;

public class AvisSurPriprietaireDto {
    private String contenu;
    private int note;
   
    private String nomClient;
    private String imageClient;

    // Constructeur basé sur AvisProprietaire
    public AvisSurPriprietaireDto(AvisProprietaire avis) {
        this.contenu = avis.getContenu();
        this.note = avis.getNote();
        
        if (avis.getClient() != null) {
            this.nomClient = avis.getClient().getName();
            this.imageClient = avis.getClient().getProfilePicture();
        } else {
            this.nomClient = "Client inconnu";
            this.imageClient = "Image non disponible";
        }
    }

    // Getters et Setters
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

   

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getImageClient() {
        return imageClient;
    }

    public void setImageClient(String imageClient) {
        this.imageClient = imageClient;
    }
}
