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
@Table(name = "ReponseSurAvisClient")
public class ReponseSurAvisClient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "responseavisP_seq_gen")
    @SequenceGenerator(name = "responseavisP_seq_gen", sequenceName = "responseavisP_seq", allocationSize = 1)
    private Long id;

    private String commentaire;

    @JsonProperty("DATE_COMMENTAIRE")  // Assurez-vous que le nom ici correspond à ce qui est envoyé dans le JSON
    @Column(name = "date_commentaire")
    private LocalDateTime dateCommentaire;


  

    

    @ManyToOne
    @JoinColumn(name = "proprietaire_id", referencedColumnName = "id")
    private Proprietaire Proprietaire;

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
    public Proprietaire getProprietaire() {
        return Proprietaire;
    }

    public void setProprietaire(Proprietaire proprietaire) {
        this.Proprietaire = proprietaire;
    }
    
}
