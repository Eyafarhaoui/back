package com.example.back.Model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ReponseSurAvisProp")
public class ReponseSurAvisProp {
   
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "responseavis_seq_gen")
    @SequenceGenerator(name = "responseavis_seq_gen", sequenceName = "responseavis_seq", allocationSize = 1)
    private Long id;

    private String commentaire;

    @JsonProperty("DATE_COMMENTAIRE")  // Assurez-vous que le nom ici correspond à ce qui est envoyé dans le JSON
    @Column(name = "date_commentaire")
    private LocalDateTime dateCommentaire;


  

    

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private client client;

    // Getter et Setter pour id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter et Setter pour commentaire
    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    // Getter et Setter pour dateCommentaire
    public LocalDateTime getDateCommentaire() {
        return dateCommentaire;
    }

    public void setDateCommentaire(LocalDateTime dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
    }

   
    // Getter et Setter pour client
    public client getClient() {
        return client;
    }

    public void setClient(client client) {
        this.client = client;
    }
}
