package com.example.back.Model;

import java.time.LocalDateTime;

public class AvisSurClientDto {
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    private String contenu;
    private int note;
    private LocalDateTime dateAvis;
    private String nomProp;
    private String  tel_propr;
    private String email_prop;

    // Constructeurs, getters et setters
    public AvisSurClientDto(AvisClient avis , String nomProp,String email_proprietaire,String tel_proprietaire) {
        this.contenu=avis.getContenu();
        this.note=avis.getNote();
        this.dateAvis=avis.getDateAvis();
        this.nomProp=nomProp;
        this.tel_propr=tel_proprietaire;
        this.email_prop=email_proprietaire;
        this.id=avis.getId();

    }
    public String getContenu() {
        return contenu;
    }

    public int getNote() {
        return note;
    }

    public LocalDateTime getDateAvis() {
        return dateAvis;
    }

    public String getNomProp() {
        return nomProp;
    }

    public String getTel_propr() {
        return tel_propr;
    }

    public String getEmail_prop() {
        return email_prop;
    }

    // Setters
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public void setDateAvis(LocalDateTime dateAvis) {
        this.dateAvis = dateAvis;
    }

    public void setNomProp(String nomProp) {
        this.nomProp = nomProp;
    }

    public void setTel_propr(String tel_propr) {
        this.tel_propr = tel_propr;
    }

    public void setEmail_prop(String email_prop) {
        this.email_prop = email_prop;
    }

        
}    
    
