package com.example.back.Model;
public class ReclamationClientDTO {

    private String nomClient;               // Nom du client
    private String contenuReclamation;      // Contenu de la réclamation
    private String PROFILE_PICTURE;  // URL de l'image du profil du propriétaire

    // Constructeur par défaut
    public ReclamationClientDTO() {}

    // Constructeur avec paramètres
    public ReclamationClientDTO(String nomClient, String contenuReclamation, String profilePictureProprietaire) {
        this.nomClient = nomClient;
        this.contenuReclamation = contenuReclamation;
        this.PROFILE_PICTURE = profilePictureProprietaire;
    }

    // Getters et Setters
    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getContenuReclamation() {
        return contenuReclamation;
    }

    public void setContenuReclamation(String contenuReclamation) {
        this.contenuReclamation = contenuReclamation;
    }

    public String getProfilePictureProprietaire() {
        return PROFILE_PICTURE;
    }

    public void setProfilePictureProprietaire(String profilePictureProprietaire) {
        this.PROFILE_PICTURE = profilePictureProprietaire;
    }

    // Méthode toString pour un affichage facile des données
    @Override
    public String toString() {
        return "ReclamationClientDTO{" +
                "nomClient='" + nomClient + '\'' +
                ", contenuReclamation='" + contenuReclamation + '\'' +
                ", profilePictureProprietaire='" + PROFILE_PICTURE + '\'' +
                '}';
    }
}
