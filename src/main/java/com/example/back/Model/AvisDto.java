package com.example.back.Model;

import java.time.LocalDateTime;

public class AvisDto {
    private String contenu;
    private int note;
    private LocalDateTime dateAvis;
    private String nomClient;
    private String imageClient;


    // Constructeurs, getters et setters
    public AvisDto(AvisProprietaire avis , String nomClient,String image_client) {
        this.contenu = avis.getContenu();
        this.note = avis.getNote();
        this.dateAvis = avis.getDateAvis();
        this.nomClient = nomClient;
        this.imageClient=image_client;
        
    }

    // Getters et setters
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

    public LocalDateTime getDateAvis() {
        return dateAvis;
    }

    public void setDateAvis(LocalDateTime dateAvis) {
        this.dateAvis = dateAvis;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

   
    public String getimageClient() {
        return imageClient;
    }

    public void setimageClient(String img) {
        this.imageClient = img;
    }
    
    
}
