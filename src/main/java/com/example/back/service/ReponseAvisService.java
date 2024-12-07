package com.example.back.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.back.Model.AvisClient;
import com.example.back.Model.AvisProprietaire;
import com.example.back.Model.CommentaireClient;
import com.example.back.Model.Proprietaire;
import com.example.back.Model.ReponseSurAvisClient;
import com.example.back.Model.ReponseSurAvisProp;
import com.example.back.Model.client;
import com.example.back.repository.ReponseSurAvisClientRepository;
import com.example.back.Model.pub;
import com.example.back.repository.ClientRepository;
import com.example.back.repository.ProprietaireRepository;
import com.example.back.repository.ReponseSurAvisPropRepository;
import com.example.back.repository.pubRepository;
import com.example.back.repository.AvisClientRepository;
import com.example.back.repository.AvisProprietaireRepository;
import com.example.back.repository.ReponseSurAvisPropRepository;
@Service
public class ReponseAvisService {


    @Autowired
    private ReponseSurAvisPropRepository  reponseRepository;
    @Autowired
    private ReponseSurAvisClientRepository  reponsecRepository;
    @Autowired
    private ReponseSurAvisPropRepository ReponseSurAvisPropRepository;

    @Autowired
    private ReponseSurAvisClientRepository ReponseSurAvisClientRepository;
    
    @Autowired
    private AvisClientRepository avisClientRepository;

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProprietaireRepository proprietaireRepository;
    @Autowired
    private AvisProprietaireRepository avisProprietaireRepository;

   public ReponseSurAvisProp saveReponse(ReponseSurAvisProp repSurAvisProp) {
        if (repSurAvisProp == null) {
            throw new IllegalArgumentException("repSurAvisProp cannot be null");
        }
    
        // Récupérer le client à partir de l'ID client
        client client = clientRepository.findById(repSurAvisProp.getClient().getId())
            .orElseThrow(() -> new IllegalArgumentException("Client not found"));
        repSurAvisProp.setClient(client);
    
        
        System.out.println("Saving repSurAvisProp: " + repSurAvisProp);
        return reponseRepository.save(repSurAvisProp);
    }
    
    
    public ReponseSurAvisClient saveReponseProp(ReponseSurAvisClient repSurAvisclient) {
        if (repSurAvisclient == null) {
            throw new IllegalArgumentException("repSurAvisProp cannot be null");
        }

        // Récupérer le propriétaire à partir de l'ID propriétaire
        Proprietaire p = proprietaireRepository.findById(repSurAvisclient.getProprietaire().getId())
            .orElseThrow(() -> new IllegalArgumentException("Propriétaire not found"));
        repSurAvisclient.setProprietaire(p);

        System.out.println("Saving repSurAvisProp: " + repSurAvisclient);
        return reponsecRepository.save(repSurAvisclient);
    }
 
    public List<ReponseSurAvisProp> getAvisByProprietaire(Long proprietaireId) {
        return ReponseSurAvisPropRepository.findByProprietaireId(proprietaireId);
    }
    public List<ReponseSurAvisProp> getReponseByCommentaireEtProprietaire(String contenuAvis, Long proprietaireId) {
        return reponseRepository.findByContenuAvisAndProprietaireId(contenuAvis, proprietaireId);
    }
    public List<ReponseSurAvisClient> getReponsesByCommentaireEtClient(String contenuAvis, Long clientId) {
        return ReponseSurAvisClientRepository.findByContenuAvisAndClientId(contenuAvis,clientId);
    }

    
}
