package com.example.back.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.back.Model.ReclamationProp;
import com.example.back.Model.ReclamationPropDTO;
import com.example.back.Model.client;
import com.example.back.Model.Proprietaire;
import com.example.back.Model.ReclamationClient;
import com.example.back.Model.ReclamationClientDTO;
import com.example.back.service.ClientService;
import com.example.back.service.ProprietaireService;
import com.example.back.service.reclamationService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/reclamation") // Point d'entrée commun
public class ReclamationController {

    @Autowired
    private reclamationService reclamationService;
    @Autowired
    private ClientService ClientService;
    @Autowired
    private ProprietaireService ProprietaireService;

    // Réclamations Client
   
    
    @PostMapping("/client")
    public ResponseEntity<ReclamationClient> createReclamationClient(@RequestBody ReclamationClient reclamationClient) {
        ReclamationClient savedRec = reclamationService.saveReclamationClient(reclamationClient);
        return new ResponseEntity<>(savedRec, HttpStatus.CREATED);
    }


    @GetMapping("/client")
@Transactional
public List<ReclamationClientDTO> getAllReclamationClients() {
    List<ReclamationClient> reclamations = reclamationService.getAllReclamationClients();
    List<ReclamationClientDTO> dtoList = new ArrayList<>();

    for (ReclamationClient rec : reclamations) {
        Optional<client> optionalClient = ClientService.getClientById(rec.getIdClient());

if (optionalClient.isPresent()) {
    client c = optionalClient.get();
    String profilePicture = c.getProfilePicture() != null 
        ? c.getProfilePicture() 
        : "default_image_url"; // URL de l'image par défaut

    ReclamationClientDTO dto = new ReclamationClientDTO(
        c.getName(),
        rec.getContenu(),
        profilePicture
    );
    System.out.println("URL de l'image du profil pour " + c.getName() + ": " + profilePicture);
    dtoList.add(dto);
} else {
    System.err.println("Aucun client trouvé avec l'ID : " + rec.getIdClient());
    // Vous pourriez ignorer cette réclamation ou lever une exception.
}

    }
    return dtoList;
}
@PostMapping("/prop")
    public ResponseEntity<ReclamationProp> createReclamationProp(@RequestBody  ReclamationProp reclamationProp){
        System.out.println("Données reçues dans le contrôleur (Client): " + reclamationProp);
        ReclamationProp savedRec = reclamationService.saveReclamationProp(reclamationProp);
        return new ResponseEntity<>(savedRec, HttpStatus.CREATED);
    }


@GetMapping("/prop")
@Transactional
public List<ReclamationPropDTO> getAllReclamationProps() {
    // Récupérer toutes les réclamations
    List<ReclamationProp> reclamations = reclamationService.getAllReclamationProps();
    
    // Liste pour stocker les DTOs
    List<ReclamationPropDTO> dtoList = new ArrayList<>();

    // Parcours de toutes les réclamations
    for (ReclamationProp rec : reclamations) {
        // Récupérer le propriétaire pour chaque réclamation
        Optional<Proprietaire> optionalProprietaire = ProprietaireService.getProprietaireById(rec.getId_proprietaire());

        // Vérifier si le propriétaire est présent
        if (optionalProprietaire.isPresent()) {
            Proprietaire prop = optionalProprietaire.get();

            // Créer un DTO et l'ajouter à la liste si le propriétaire est trouvé
            ReclamationPropDTO dto = new ReclamationPropDTO(
                prop.getNom(),
                rec.getContenu(),
                prop.getTelephone(),
                prop.getEmail()
            );
            dtoList.add(dto);
        } else {
            // Gérer le cas où le propriétaire n'est pas trouvé (par exemple, loguer ou ajouter un DTO par défaut)
            System.out.println("Propriétaire non trouvé pour l'ID: " + rec.getId_proprietaire());
        }
    }

    // Retourner la liste des DTOs
    return dtoList;
}

}