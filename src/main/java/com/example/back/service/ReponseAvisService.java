package com.example.back.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.back.Model.AvisClient;
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
@Service
public class ReponseAvisService {


    @Autowired
    private ReponseSurAvisPropRepository  reponseRepository;
    @Autowired
    private ReponseSurAvisClientRepository  reponsePRepository;

    @Autowired
    private AvisClientRepository avisClientRepository;

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProprietaireRepository proprietaireRepository;

    
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
    
    
    public ReponseSurAvisClient saveReponseProp(ReponseSurAvisClient repSurAvisProp) {
        if (repSurAvisProp == null) {
            throw new IllegalArgumentException("repSurAvisProp cannot be null");
        }

        // Récupérer le propriétaire à partir de l'ID propriétaire
        Proprietaire p = proprietaireRepository.findById(repSurAvisProp.getProprietaire().getId())
            .orElseThrow(() -> new IllegalArgumentException("Propriétaire not found"));
        repSurAvisProp.setProprietaire(p);

        System.out.println("Saving repSurAvisProp: " + repSurAvisProp);
        return reponsePRepository.save(repSurAvisProp);
    }
 
    
  
}
