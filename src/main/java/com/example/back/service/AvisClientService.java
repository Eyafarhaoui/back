package com.example.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.back.Model.AvisClient;
import com.example.back.repository.AvisClientRepository;

@Service
public class AvisClientService {

    @Autowired
    private AvisClientRepository avisClientRepository;

    public AvisClient ajouterAvis(AvisClient avis) {
        return avisClientRepository.save(avis);
    }

    public List<AvisClient> getAvisParClient(Long clientId) {
        return avisClientRepository.findByClientId(clientId);
    }
    public Long getProprietaireIdByContenu(String contenu) {
        AvisClient avisClient = avisClientRepository.findByContenu(contenu)
                .orElseThrow(() -> new RuntimeException("Avis non trouvé avec ce contenu"));
        return avisClient.getProprietaire().getId();
    }
}

