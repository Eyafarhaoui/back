package com.example.back.Model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "RESERVATION")
public class Reservation {@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_seq")
@SequenceGenerator(name = "reservation_seq", sequenceName = "reservation_sequence", allocationSize = 1)
    private Long id;
    private Long voitureId;
    private Long proprietaireId;
    private Long clientId;
    private LocalDate dateDebut; // Changement de type
    private LocalDate dateFin;
    private BigDecimal montantTotal;
    private BigDecimal  montantPaye;
   
    public Long getVoitureId() {
        return voitureId;
    }
    public void setVoitureId(Long voitureId) {
        this.voitureId = voitureId;
    }
    public Long getProprietaireId() {
        return proprietaireId;
    }
    public void setProprietaireId(Long proprietaireId) {
        this.proprietaireId = proprietaireId;
    }
    public Long getClientId() {
        return clientId;
    }
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
    public LocalDate getDateDebut() {
        return dateDebut;
    }
    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }
    public LocalDate getDateFin() {
        return dateFin;
    }
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
    public BigDecimal getMontantTotal() {
        return montantTotal;
    }
    public void setMontantTotal(BigDecimal montantTotal) {
        this.montantTotal = montantTotal;
    }
    public BigDecimal getMontantPaye() {
        return montantPaye;
    }
    public void setMontantPaye(BigDecimal montantPaye) {
        this.montantPaye = montantPaye;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
