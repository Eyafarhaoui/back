package com.example.back.Model;

import java.math.BigDecimal;

public class VoitureDTO {
    private Long id;

    private String matricule;
    private String marque;
    private String modele;
    private Integer annee;
    private String couleur;
    private BigDecimal prix;
    private String description;
    private String etat;
    private Integer nombrePortes;
    private Boolean airConditionne;
    private String typeCarburant;
    private String boiteVitesse;
    private Integer nombreChevaux;
    private Integer nombrePassagers;
    private BigDecimal prixParJour;
    private BigDecimal montantCaution;
    private Long proprietaireId;
    public Long getId() {
        return id;
    }
    public VoitureDTO(Voiture voiture) {
        this.id = voiture.getId();
        this.matricule = voiture.getMatricule();
        this.marque = voiture.getMarque();
        this.modele = voiture.getModele();
        this.annee = voiture.getAnnee();
        this.couleur = voiture.getCouleur();
        this.prix = voiture.getPrix();
        this.description = voiture.getDescription();
        this.etat = voiture.getEtat();
        this.nombrePortes = voiture.getNombrePortes();
        this.airConditionne = voiture.getAirConditionne();
        this.typeCarburant = voiture.getTypeCarburant();
        this.boiteVitesse = voiture.getBoiteVitesse();
        this.nombreChevaux = voiture.getNombreChevaux();
        this.nombrePassagers = voiture.getNombrePassagers();
        this.prixParJour = voiture.getPrixParJour();
        this.montantCaution = voiture.getMontantCaution();
        this.proprietaireId = voiture.getProprietaireId();
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public String getModele() {
        return modele;
    }
    public void setModele(String modele) {
        this.modele = modele;
    }
    public Integer getAnnee() {
        return annee;
    }
    public void setAnnee(Integer annee) {
        this.annee = annee;
    }
    public String getCouleur() {
        return couleur;
    }
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    public BigDecimal getPrix() {
        return prix;
    }
    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getEtat() {
        return etat;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }
    public Integer getNombrePortes() {
        return nombrePortes;
    }
    public void setNombrePortes(Integer nombrePortes) {
        this.nombrePortes = nombrePortes;
    }
    public Boolean getAirConditionne() {
        return airConditionne;
    }
    public void setAirConditionne(Boolean airConditionne) {
        this.airConditionne = airConditionne;
    }
    public String getTypeCarburant() {
        return typeCarburant;
    }
    public void setTypeCarburant(String typeCarburant) {
        this.typeCarburant = typeCarburant;
    }
    public String getBoiteVitesse() {
        return boiteVitesse;
    }
    public void setBoiteVitesse(String boiteVitesse) {
        this.boiteVitesse = boiteVitesse;
    }
    public Integer getNombreChevaux() {
        return nombreChevaux;
    }
    public void setNombreChevaux(Integer nombreChevaux) {
        this.nombreChevaux = nombreChevaux;
    }
    public Integer getNombrePassagers() {
        return nombrePassagers;
    }
    public void setNombrePassagers(Integer nombrePassagers) {
        this.nombrePassagers = nombrePassagers;
    }
    public BigDecimal getPrixParJour() {
        return prixParJour;
    }
    public void setPrixParJour(BigDecimal prixParJour) {
        this.prixParJour = prixParJour;
    }
    public BigDecimal getMontantCaution() {
        return montantCaution;
    }
    public void setMontantCaution(BigDecimal montantCaution) {
        this.montantCaution = montantCaution;
    }
    public Long getProprietaireId() {
        return proprietaireId;
    }
    public void setProprietaireId(Long proprietaireId) {
        this.proprietaireId = proprietaireId;
    }
    
}
