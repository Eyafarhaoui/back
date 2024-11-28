package com.example.back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.back.Model.ReclamationClient;
import com.example.back.Model.ReclamationProp;
import com.example.back.repository.ReclamationClientRepository;
import com.example.back.repository.reclamationPropRepository;

@Service
public class reclamationService {

    @Autowired
    private ReclamationClientRepository reclamationClientRepository;

    @Autowired
    private reclamationPropRepository reclamationPropRepository;

    /**
     * Sauvegarde une réclamation client dans la base de données.
     *
     * @param reclamationClient la réclamation client à sauvegarder.
     * @return l'objet ReclamationClient sauvegardé.
     * @throws IllegalArgumentException si reclamationClient est null.
     */
    public ReclamationClient saveReclamationClient(ReclamationClient reclamationClient) {
        if (reclamationClient == null) {
            throw new IllegalArgumentException("ReclamationClient cannot be null");
        }
        System.out.println("ID du client avant sauvegarde: " + reclamationClient.getClient().getId());
        System.out.println("Saving ReclamationClient: " + reclamationClient);
        return reclamationClientRepository.save(reclamationClient);
    }

    /**
     * Récupère une réclamation client par son ID.
     *
     * @param id l'ID de la réclamation client.
     * @return l'objet ReclamationClient correspondant, ou null s'il n'existe pas.
     */
    public ReclamationClient findReclamationClientById(Long id) {
        Optional<ReclamationClient> reclamation = reclamationClientRepository.findById(id);
        return reclamation.orElse(null);
    }

    /**
     * Récupère toutes les réclamations clients.
     *
     * @return une liste de toutes les réclamations clients.
     */
    public List<ReclamationClient> getAllReclamationClients() {
        return reclamationClientRepository.findAll();
    }

    /**
     * Sauvegarde une réclamation propriétaire dans la base de données.
     *
     * @param reclamationProp la réclamation propriétaire à sauvegarder.
     * @return l'objet ReclamationProp sauvegardé.
     * @throws IllegalArgumentException si reclamationProp est null.
     */
    public ReclamationProp saveReclamationProp(ReclamationProp reclamationProp) {
        if (reclamationProp == null) {
            throw new IllegalArgumentException("ReclamationProp cannot be null");
        }
        System.out.println("ID du propriétaire avant sauvegarde: " + reclamationProp.getProprietaire().getId());
        System.out.println("Saving ReclamationProp: " + reclamationProp);
        return reclamationPropRepository.save(reclamationProp);
    }

    /**
     * Récupère une réclamation propriétaire par son ID.
     *
     * @param id l'ID de la réclamation propriétaire.
     * @return l'objet ReclamationProp correspondant, ou null s'il n'existe pas.
     */
    public ReclamationProp findReclamationPropById(Long id) {
        Optional<ReclamationProp> reclamation = reclamationPropRepository.findById(id);
        return reclamation.orElse(null);
    }

    /**
     * Récupère toutes les réclamations propriétaires.
     *
     * @return une liste de toutes les réclamations propriétaires.
     */
    public List<ReclamationProp> getAllReclamationProps() {
        return reclamationPropRepository.findAll();
    }
}
