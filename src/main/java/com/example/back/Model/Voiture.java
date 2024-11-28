package com.example.back.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voiture_seq_gen")
    @SequenceGenerator(name = "voiture_seq_gen", sequenceName = "voiture_seq", allocationSize = 1)
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
    private String imagePath;
    private Long proprietaireId;

    @Column(columnDefinition = "BLOB")
    private byte[] imageVoiture;


    public byte[] getImageVoiture(){
        return this.imageVoiture;
    }

    public void setImageVoiture(byte[] imageVoiture){
        this.imageVoiture = imageVoiture;
    }

    @OneToMany(mappedBy = "voiture" ,fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Disponibilite> disponibilites;

    public Long getId() {
        return id;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Long getProprietaireId() {
        return proprietaireId;
    }

    public void setProprietaireId(Long proprietaireId) {
        this.proprietaireId = proprietaireId;
    }

    public List<Disponibilite> getDisponibilites() {
        return disponibilites;
    }

    public void setDisponibilites(List<Disponibilite> disponibilites) {
        this.disponibilites = disponibilites;
    }

  
}
