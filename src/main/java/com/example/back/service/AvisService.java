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
import com.example.back.Model.AvisSurPriprietaireDto;
import com.example.back.Model.AvisDto;
import com.example.back.Model.client;
import com.example.back.Model.AvisProprietaireDTO;

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
    @Autowired
    private AvisProprietaireRepository AvisProprietaireRepository;

    public List<AvisSurPriprietaireDto> getAvisByProprietaire(Long idProprietaire) {
        if (idProprietaire == null) {
            throw new IllegalArgumentException("The given id must not be null");
        }
    
        // Récupérer les avis associés au propriétaire
        List<AvisProprietaire> avisList = avisProprietaireRepository.findByProprietaireId(idProprietaire);
        List<AvisSurPriprietaireDto> avisDTOs = new ArrayList<>();
    
        // Convertir chaque avis en AvisSurPriprietaireDto
        for (AvisProprietaire avi : avisList) {
            avisDTOs.add(new AvisSurPriprietaireDto(avi));
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

// Nouvelle méthode pour récupérer les avis faits par un client
public List<AvisProprietaireDTO> getAvisFaitsParClient(Long idclient) {
    if (idclient == null) {
        throw new IllegalArgumentException("The given id must not be null");
    }

    // Récupérer les avis faits par le propriétaire
    List<AvisProprietaire> avisList = AvisProprietaireRepository.findByClientId(idclient);
    List<AvisProprietaireDTO> avisDTOs = new ArrayList<>();

    // Transformer chaque avis en AvisDto
    for (AvisProprietaire avis : avisList) {
        // Utiliser un tableau pour la modification dans la lambda
        final String[] nom_Proprietaire= { "Nom non disponible" };
        
        if (avis.getProprietaire() != null) {
            Optional<Proprietaire> ProprietaireOpt = proprietaireRepository.findById(avis.getProprietaire().getId());
            ProprietaireOpt.ifPresent(Proprietaire -> {
                nom_Proprietaire[0] =Proprietaire.getNom();
            });
        }

        // Créer et ajouter l'objet AvisDto à la liste
        avisDTOs.add(new AvisProprietaireDTO(avis ,nom_Proprietaire[0]) );
    }

    return avisDTOs;
}



// Nouvelle méthode pour récupérer les avis faits par un propriétaire
public List<AvisDto> getAvisFaitsParProprietaire(Long idProprietaire) {
    if (idProprietaire == null) {
        throw new IllegalArgumentException("The given id must not be null");
    }

    // Récupérer les avis faits par le propriétaire
    List<AvisClient> avisList = avisclientrepository.findByProprietaireId(idProprietaire);
    List<AvisDto> avisDTOs = new ArrayList<>();

    // Transformer chaque avis en AvisDto
    for (AvisClient avis : avisList) {
        // Utiliser un tableau pour la modification dans la lambda
        final String[] nom_client = { "Nom non disponible" };
        final String[] image_client = { "image non disponible" };
        
        if (avis.getClient() != null) {
            Optional<client> clientOpt = clientRepository.findById(avis.getClient().getId());
            clientOpt.ifPresent(client -> {
                nom_client[0] = client.getName();
            });
        }

        // Créer et ajouter l'objet AvisDto à la liste
        avisDTOs.add(new AvisDto(avis, nom_client[0], image_client[0]));
    }

    return avisDTOs;
}



















    




}
