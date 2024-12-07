package com.example.back.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.back.Model.AvisClient;
import com.example.back.Model.AvisProprietaire;
import com.example.back.repository.AvisProprietaireRepository;

@Service
public class AvisProprietaireService {
    @Autowired
    private AvisProprietaireRepository avisProprietaireRepository;
    public AvisProprietaire ajouterAvis(AvisProprietaire avis) {
        return avisProprietaireRepository.save(avis);
    }
    
    public List<AvisProprietaire> getAvisParProprietaire(Long ProprietaireId) {
        return avisProprietaireRepository.findByProprietaireId(ProprietaireId);
    }
    public Long getClientIdByContenu(String contenu) {
        AvisProprietaire avisProp = avisProprietaireRepository.findByContenu(contenu)
                .orElseThrow(() -> new RuntimeException("Avis non trouvé avec ce contenu"));
        return avisProp.getClient().getId();
    }
    
}



