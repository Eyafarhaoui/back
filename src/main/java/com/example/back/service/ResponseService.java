package com.example.back.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;


import com.example.back.Model.Response;
import com.example.back.Model.ResponseDTO;
import com.example.back.Model.pub;
import com.example.back.Model.Proprietaire;
import com.example.back.repository.ResponseRepository;
import com.example.back.repository.pubRepository;
import com.example.back.repository.ProprietaireRepository;

@Service
public class ResponseService {
    @Autowired
    private ResponseRepository ResponseRepository;
    @Autowired
    private pubRepository pubRepository;
    @Autowired
    private ProprietaireRepository ProprietaireRepository;;

    public Response saveResponse(Response Response) {
        if (Response == null) {
            throw new IllegalArgumentException("Response cannot be null");
        }
       
        return ResponseRepository.save(Response);
    }
  


    public Response findById(Long id) {
        Optional<Response> Response =ResponseRepository.findById(id);
        return Response.orElse(null); 
    }

    public List<Response> getAllResponse() {
        return ResponseRepository.findAll();
    }
   
    public List<ResponseDTO> getResponseByIdClient(Long idClient) {
        if (idClient == null) {
            throw new IllegalArgumentException("The given id must not be null");
        }
        List<Response> responses = ResponseRepository.findByIdClient(idClient);
        List<ResponseDTO> responseDTOs = new ArrayList<>();
       
        for (Response response : responses) {
            pub pub = pubRepository.findById(response.getIdPublication()).orElse(null);
            String publicationContenu = (pub != null) ? pub.getContenu() : "Contenu non disponible";
        
            // Utiliser un tableau pour permettre la modification dans la lambda
            final String[] nom_prop = { "Nom non disponible" };
            final String[] email_prop = { "Email non disponible" };
            final String[] tel_prop = { "Téléphone non disponible" };
        
            Optional<Proprietaire> proprietaireOpt = ProprietaireRepository.findById(response.getIdProprietaire());
            proprietaireOpt.ifPresent(proprietaire -> {
                nom_prop[0] = proprietaire.getNom();
                email_prop[0] = proprietaire.getEmail();
                tel_prop[0] = proprietaire.getTelephone();
            });
        
            // Ajouter l'objet ResponseDTO à la liste
            responseDTOs.add(new ResponseDTO(response, publicationContenu, nom_prop[0], email_prop[0], tel_prop[0]));
        }
        return responseDTOs;
    }

    

}