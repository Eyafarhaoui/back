package com.example.back.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.back.Model.CommentaireClient;
import com.example.back.Model.ReponseSurAvisProp;
import com.example.back.Model.ReponseSurAvisClient;
import com.example.back.service.ReponseAvisService;
@RestController
@RequestMapping("/api/reponseavis")

public class ReponseAvisController {
    @Autowired
    private ReponseAvisService avisService;

    @PostMapping("/submit-comment")
    public ResponseEntity<ReponseSurAvisProp> submitComment(@RequestBody ReponseSurAvisProp commentaireRequest) {
        System.out.println("Données reçues dans le contrôleur: " + commentaireRequest);
        ReponseSurAvisProp commsaved=  avisService.saveReponse(commentaireRequest);
        return new ResponseEntity<>(commsaved, HttpStatus.CREATED);
    }
    @PostMapping("/submit-comment-prop")

    public ResponseEntity<ReponseSurAvisClient> submitCommentProp(@RequestBody ReponseSurAvisClient  commentaireRequest) {
        System.out.println("Données reçues dans le contrôleur: " + commentaireRequest);
        ReponseSurAvisClient commsaved = avisService.saveReponseProp(commentaireRequest);
        return new ResponseEntity<>(commsaved, HttpStatus.CREATED);
    }
    @GetMapping("/get-reponses")
    public ResponseEntity<List<ReponseSurAvisProp>> getReponsesByCommentaireEtProprietaire(
        @RequestParam String contenuAvis,
        @RequestParam Long proprietaireId) {
        
        // Affichage des valeurs reçues pour vérifier le décodage
        System.out.println("Recherche des réponses pour l'avis : '" + contenuAvis + "' et le propriétaire ID : " + proprietaireId);
        
        // Traitement des données
        List<ReponseSurAvisProp> reponses = avisService.getReponseByCommentaireEtProprietaire(contenuAvis, proprietaireId);
        
        return new ResponseEntity<>(reponses, HttpStatus.OK);
    } 
    @GetMapping("/get-reponses-sur-AvisClient")
    public ResponseEntity<List<ReponseSurAvisClient>>getReponsesByCommentaireEtClient(
        @RequestParam String contenuAvis,
        @RequestParam Long clientId) {
        
        // Affichage des valeurs reçues pour vérifier le décodage
        System.out.println("Recherche des réponses pour l'avis : '" + contenuAvis + "' et le client ID : " + clientId);
        
        // Traitement des données
        List<ReponseSurAvisClient> reponses = avisService.getReponsesByCommentaireEtClient(contenuAvis, clientId);
        
        return new ResponseEntity<>(reponses, HttpStatus.OK);
    }


}
