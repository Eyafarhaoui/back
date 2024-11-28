package com.example.back.Model;

import jakarta.persistence.*;

@Entity
public class pub {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pub_seq_gen")
    @SequenceGenerator(name = "pub_seq_gen", sequenceName = "pub_seq", allocationSize = 1)
    private Long idPub;

    private Long idClient;
    private String contenu;


    public Long getIdClient() {
        return idClient;
    }
    

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Long getIdPub() {
        return idPub;
    }

    public void setIdPub(Long idPub) {
        this.idPub = idPub;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}