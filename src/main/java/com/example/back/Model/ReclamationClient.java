package com.example.back.Model;

import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class ReclamationClient {
    

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rec_seqc_gen")
    @SequenceGenerator(name = "rec_seqc_gen", sequenceName = "rec_seqc_seq", allocationSize = 1)
    private Long idRec;

    private String contenu;

    // Nouveau champ idClient
    private Long idClient;

    /*@ManyToOne
    @JoinColumn(name = "idClient", referencedColumnName = "id", insertable = false, updatable = false)
    private client client; // Relation avec l'entité Client*/

    // Getter et Setter pour idClient
    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    // Getter et Setter pour client
    /*public client getClient() {
        return client;
    }

    public void setClient(client client) {
        this.client = client;
    }*/

    // Getter et Setter pour idRec
    public Long getIdRec() {
        return idRec;
    }

    public void setIdRec(Long idRec) {
        this.idRec = idRec;
    }

    // Getter et Setter pour contenu
    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    
}