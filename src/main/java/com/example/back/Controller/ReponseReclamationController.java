package com.example.back.Controller;

import org.springframework.web.bind.annotation.*;
import com.example.back.Model.ReponseReclamation;
import com.example.back.Model.ReponseReclamationClient;
import com.example.back.service.ReponseReclamationService;

import jakarta.transaction.Transactional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/ReponseReclamation")
public class ReponseReclamationController {
    @Autowired
    private ReponseReclamationService ReponseReclamationService;
    

    @PostMapping
    public ResponseEntity<ReponseReclamation> createResponsRec(@RequestBody ReponseReclamation ReponseReclamation) {
        System.out.println("Données reçues dans le contrôleur: " + ReponseReclamation);
        ReponseReclamation savedResponsRec = ReponseReclamationService.createResponsRec(ReponseReclamation);
        return new ResponseEntity<>(savedResponsRec, HttpStatus.CREATED);
    }
    

    @PostMapping("/client")
    public ResponseEntity<ReponseReclamationClient> createResponsRecClient(@RequestBody ReponseReclamationClient ReponseReclamation) {
        System.out.println("Requête reçue : " + ReponseReclamation);
        try {
            ReponseReclamationClient savedResponsRec = ReponseReclamationService.createReponseReclamationClient(ReponseReclamation);
            System.out.println("Réponse enregistrée : " + savedResponsRec);
            return new ResponseEntity<>(savedResponsRec, HttpStatus.CREATED);
        } catch (Exception e) {
           e.printStackTrace();
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
}


    @Transactional
    @GetMapping
    public List<ReponseReclamation> getAllResponsRec() {
        return ReponseReclamationService.getAllResponsRec();
    }
}

    

