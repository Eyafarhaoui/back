package com.example.back.Model;

public class AvisProprietaireDTO {
    private String contenu;
    private int note;
    private String nomProprietaire;


    public AvisProprietaireDTO(AvisProprietaire avis , String nomProprietaire) {
        this.contenu = avis.getContenu();
        this.note = avis.getNote();
        this.nomProprietaire = nomProprietaire;
        
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

    public String getNomProp() {
        return nomProprietaire;
    }

    public void setNomProp(String n) {
        this.nomProprietaire = n;
    }
   
 
    
    
    
}
