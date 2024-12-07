package com.example.back.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class ReclamationProp {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rec_seqp_gen")
    @SequenceGenerator(name = "rec_seqp_gen", sequenceName = "rec_seqp_seq", allocationSize = 1)
    private Long idRec;
    private Long id_proprietaire;
    public Long getId_proprietaire() {
        return id_proprietaire;
    }
    public void setId_proprietaire(Long id_proprietaire) {
        this.id_proprietaire = id_proprietaire;
    }

    private String contenu;

    /*@ManyToOne
    @JoinColumn(name = "id_proprietaire", referencedColumnName = "id")
    private Proprietaire proprietaire;  // Relation avec l'entité Proprietaire*/

   
    // Getter et setter pour idRec
    public Long getIdRec() {
        return idRec;
    }

    public void setIdRec(Long idRec) {
        this.idRec = idRec;
    }

    // Getter et setter pour contenu
    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    // Getter et setter pour le propriétaire
    /*public Proprietaire getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }*/

}
