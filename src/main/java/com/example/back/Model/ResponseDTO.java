package com.example.back.Model;
import com.example.back.Model.Response;

public class ResponseDTO {
    private Long idResponse;
    private Long idPublication;
    private Long idClient;
    private Long idProprietaire;
    private String responsecontenu;
    private String publicationContenu;
    

    private String nom_prop;
    private String email_prop;
    private String tel_prop;

    // Constructeurs
    public ResponseDTO(Response response, String publicationContenu,String nom_prop,String email_prop,String tel_prop) {
        this.idResponse = response.getIdResponse();
        this.idPublication = response.getIdPublication();
        this.idClient = response.getIdClient();
        this.idProprietaire = response.getIdProprietaire();
        this.responsecontenu = response.getResponsecontenu();
        this.publicationContenu = publicationContenu;
        this.email_prop =email_prop;
        this.nom_prop =nom_prop;
        this.tel_prop = tel_prop;
    }

    // Getters
    public Long getIdResponse() {
        return idResponse;
    }

    public Long getIdPublication() {
        return idPublication;
    }

    public Long getIdClient() {
        return idClient;
    }

    public Long getIdProprietaire() {
        return idProprietaire;
    }

    public String getResponsecontenu() {
        return responsecontenu;
    }

    public String getPublicationContenu() {
        return publicationContenu;
    }

    // Setters
    public void setIdResponse(Long idResponse) {
        this.idResponse = idResponse;
    }

    public void setIdPublication(Long idPublication) {
        this.idPublication = idPublication;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public void setIdProprietaire(Long idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    public void setResponsecontenu(String responsecontenu) {
        this.responsecontenu = responsecontenu;
    }

    public void setPublicationContenu(String publicationContenu) {
        this.publicationContenu = publicationContenu;
    }

    public String getEmail_prop() {
        return email_prop;
    }
    
    public void setEmail_prop(String email_prop) {
        this.email_prop = email_prop;
    }
    
    // Getter et setter pour nom_prop
    public String getNom_prop() {
        return nom_prop;
    }
    
    public void setNom_prop(String nom_prop) {
        this.nom_prop = nom_prop;
    }
    
    // Getter et setter pour tel_prop
    public String getTel_prop() {
        return tel_prop;
    }
    
    public void setTel_prop(String tel_prop) {
        this.tel_prop = tel_prop;
    }
}