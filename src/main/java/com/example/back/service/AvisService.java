package com.example.back.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.back.Model.AvisProprietaire;
import com.example.back.Model.Proprietaire;
import com.example.back.repository.AvisClientRepository;
import com.example.back.repository.AvisProprietaireRepository;
import com.example.back.repository.ProprietaireRepository;
import com.example.back.repository.ClientRepository;

import com.example.back.Model.AvisClient;
import com.example.back.Model.AvisSurClientDto;
import com.example.back.Model.AvisDto;
import com.example.back.Model.client;


@Service
public class AvisService {
    @Autowired
    private AvisProprietaireRepository avisProprietaireRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProprietaireRepository proprietaireRepository;
    @Autowired
    private AvisClientRepository avisclientrepository;

    public List<AvisDto> getAvisByProprietaire(Long idProprietaire) {
        if (idProprietaire == null) {
            throw new IllegalArgumentException("The given id must not be null");
        }
       //recuperer les avis sur le prop connecte 
        List<AvisProprietaire> avisList = avisProprietaireRepository.findByProprietaireId(idProprietaire);
        List<AvisDto>avisDTOs = new ArrayList<>();
       //recupere donnee de client qui a fait l avis 
       for (AvisProprietaire avi : avisList) {
        // Utiliser un tableau pour permettre la modification dans la lambda
        final String[] nom_client = { "Nom non disponible" };
        final String[] image_client = { "image non disponible" };
        
        // Récupérer le client à partir de l'objet avi
        if (avi.getClient() != null) {
            Optional<client> clientOpt = clientRepository.findById(avi.getClient().getId());
            
            clientOpt.ifPresent(client -> {
                nom_client[0] = client.getName();
                image_client[0] =client.getProfilePicture();
            });
        }
    
        // Ajouter l'objet AvisDto à la liste
        avisDTOs.add(new AvisDto(avi, nom_client[0],image_client[0]));
    }
    
        return avisDTOs;
    }
    public List<AvisSurClientDto> getAvisByClient(Long idClient) {
    if (idClient == null) {
        throw new IllegalArgumentException("The given id must not be null");
    }

    // Récupérer les avis sur le client
    List<AvisClient> avisList = avisclientrepository.findByClientId(idClient);
    List<AvisSurClientDto> avisDTOs = new ArrayList<>();

    // Récupérer les informations du propriétaire qui a laissé l'avis
    for (AvisClient avis : avisList) {
        // Utiliser un tableau pour permettre la modification dans la lambda
        final String[] nom_proprietaire = { "Nom non disponible" };
       
        final String[] email_proprietaire = { "email non disponible" };
        final String[] tel_proprietaire = { "tel non disponible" };

        // Récupérer le propriétaire à partir de l'objet avis
        if (avis.getProprietaire() != null) {
            Optional<Proprietaire> proprietaireOpt = proprietaireRepository.findById(avis.getProprietaire().getId());

            proprietaireOpt.ifPresent(proprietaire -> {
                nom_proprietaire[0] = proprietaire.getNom();
                email_proprietaire[0] = proprietaire.getEmail();  // Assurez-vous que `Proprietaire` a un champ pour l'image
                tel_proprietaire[0] = proprietaire.getTelephone(); 
            });
        }

        // Ajouter l'objet AvisDto à la liste
        avisDTOs.add(new AvisSurClientDto(avis, nom_proprietaire[0], email_proprietaire[0], tel_proprietaire[0]));
    }

    return avisDTOs;
}






















    




}
