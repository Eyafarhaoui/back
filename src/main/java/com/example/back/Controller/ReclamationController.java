package com.example.back.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.back.Model.ReclamationProp;
import com.example.back.Model.ReclamationPropDTO;
import com.example.back.Model.Proprietaire;
import com.example.back.Model.ReclamationClient;
import com.example.back.Model.ReclamationClientDTO;
import com.example.back.service.reclamationService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/reclamation") // Point d'entrée commun
public class ReclamationController {

    @Autowired
    private reclamationService reclamationService;

    // Réclamations Client
    @PostMapping("/client")
    public ResponseEntity<ReclamationClient> createReclamationClient(@RequestBody ReclamationClient reclamationClient) {
        System.out.println("Données reçues dans le contrôleur (Client): " + reclamationClient);
        ReclamationClient savedRec = reclamationService.saveReclamationClient(reclamationClient);
        return new ResponseEntity<>(savedRec, HttpStatus.CREATED);
    }

    @GetMapping("/client")
@Transactional
public List<ReclamationClientDTO> getAllReclamationClients() {
    List<ReclamationClient> reclamations = reclamationService.getAllReclamationClients();
    List<ReclamationClientDTO> dtoList = new ArrayList<>();

    for (ReclamationClient rec : reclamations) {
        String profilePicture = rec.getClient().getProfilePicture() != null 
            ? rec.getClient().getProfilePicture() 
            : "default_image_url"; // Remplacez "default_image_url" par l'URL réelle de l'image par défaut
        ReclamationClientDTO dto = new ReclamationClientDTO(
            rec.getClient().getName(),
            rec.getContenu(),
            profilePicture
        );
        System.out.println("URL de l'image du profil pour " + rec.getClient().getName() + ": " + rec.getClient().getProfilePicture());

        dtoList.add(dto);
    }
    return dtoList;
}



    /*@GetMapping("/client/{id}")
    public ResponseEntity<ReclamationClient> getReclamationClientById(@PathVariable Long id) {
        ReclamationClient rec = reclamationService.getReclamationClientById(id);
        return new ResponseEntity<>(rec, HttpStatus.OK);
    }*/

    // Réclamations Propriétaire
   
    @PostMapping("/prop")
    public ResponseEntity<ReclamationProp> createReclamationProp(@RequestBody  ReclamationProp reclamationProp){
        System.out.println("Données reçues dans le contrôleur (Client): " + reclamationProp);
        ReclamationProp savedRec = reclamationService.saveReclamationProp(reclamationProp);
        return new ResponseEntity<>(savedRec, HttpStatus.CREATED);
    }

       


   @GetMapping("/prop")
    @Transactional
    public List<ReclamationPropDTO> getAllReclamationProps() {
        List<ReclamationProp> reclamations = reclamationService.getAllReclamationProps();
        List<ReclamationPropDTO> dtoList = new ArrayList<>();

        for (ReclamationProp rec : reclamations) {
            Proprietaire prop = rec.getProprietaire();
            ReclamationPropDTO dto = new ReclamationPropDTO(
                prop.getNom(),
                rec.getContenu(),
                prop.getTelephone(),
                prop.getEmail()
        );
        dtoList.add(dto);
    }

    return dtoList;
} 

    /*@GetMapping("/prop/{id}")
    public ResponseEntity<ReclamationProp> getReclamationPropById(@PathVariable Long id) {
        ReclamationProp rec = reclamationService.getReclamationPropById(id);
        return new ResponseEntity<>(rec, HttpStatus.OK);
    }*/
}
