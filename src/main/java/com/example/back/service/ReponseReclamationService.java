package com.example.back.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.back.Model.ReponseReclamation;
import com.example.back.Model.ReponseReclamationClient;

import com.example.back.repository.ReponseReclamationRepository;
import com.example.back.repository.reponseReclamationClientRepository;

@Service
public class ReponseReclamationService {

    @Autowired
    private ReponseReclamationRepository reponseReclamationRepository;
    @Autowired
    private reponseReclamationClientRepository reponseRecClientRepository;
    /**
     * Crée une nouvelle réponse à une réclamation.
     * 
     * @param reponseReclamation L'objet représentant la réponse.
     * @return La réponse enregistrée.
     */
    public ReponseReclamation createResponsRec(ReponseReclamation reponseReclamation) {
        if (reponseReclamation == null) {
            throw new IllegalArgumentException("ReponseReclamation cannot be null");
        }
        //System.out.println("ID du client avant sauvegarde: " + reponseReclamation.getIdClient());
        System.out.println("Saving ReponseReclamation: " + reponseReclamation);
        return reponseReclamationRepository.save(reponseReclamation);
    }
    public ReponseReclamationClient createReponseReclamationClient(ReponseReclamationClient reponseReclamation) {
        if (reponseReclamation == null) {
            throw new IllegalArgumentException("ReponseReclamationClient cannot be null");
        }
        //System.out.println("ID du client avant sauvegarde: " + reponseReclamation.getIdClient());
        System.out.println("Saving ReponseReclamationClient: " + reponseReclamation);
        return reponseRecClientRepository.save(reponseReclamation);
    }
    /**
     * Recherche une réponse par son ID.
     * 
     * @param id L'ID de la réponse.
     * @return L'objet ReponseReclamation trouvé, ou null s'il n'existe pas.
     */
    public ReponseReclamation findById(Long id) {
        Optional<ReponseReclamation> reponseReclamation = reponseReclamationRepository.findById(id);
        return reponseReclamation.orElse(null);
    }

    /**
     * Récupère toutes les réponses enregistrées.
     * 
     * @return Une liste de toutes les réponses.
     */
    public List<ReponseReclamation> getAllResponsRec() {
        return reponseReclamationRepository.findAll();
    }
}
