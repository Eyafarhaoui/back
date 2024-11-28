package com.example.back.Model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Disponibilite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disponibilite_seq_gen")
    @jakarta.persistence.SequenceGenerator(name = "disponibilite_seq_gen", sequenceName = "disponibilite_seq", allocationSize = 1)
    private Long id;

   @JsonFormat(pattern = "yyyy-MM-dd")
private LocalDate dateDebutDisponibilite;

@JsonFormat(pattern = "yyyy-MM-dd")
private LocalDate dateFinDisponibilite;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "voiture_id")
    private Voiture voiture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  
    public LocalDate getDateDebutDisponibilite() {
        return dateDebutDisponibilite;
    }

    public void setDateDebutDisponibilite(LocalDate dateDebutDisponibilite) {
        this.dateDebutDisponibilite = dateDebutDisponibilite;
    }

    public LocalDate getDateFinDisponibilite() {
        return dateFinDisponibilite;
    }

    public void setDateFinDisponibilite(LocalDate dateFinDisponibilite) {
        this.dateFinDisponibilite = dateFinDisponibilite;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }
}
