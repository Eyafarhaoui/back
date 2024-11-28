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

    @ManyToOne
    @JoinColumn(name = "idClient", referencedColumnName = "id")
    private client client;  // Relation avec l'entité Proprietaire

    public client getClient() {
        return client;
    }

    public void setClient(client client) {
        this.client = client;
    }

    public Long getIdRec() {
        return idRec;
    }

    public void setIdRec(Long idPub) {
        this.idRec = idPub;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    
}
