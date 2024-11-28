package com.example.back.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.back.Model.CommentaireClient;
import com.example.back.Model.ReponseSurAvisProp;
import com.example.back.Model.ReponseSurAvisClient;
import com.example.back.Model.pub;
import com.example.back.service.ReponseAvisService;
import com.example.back.service.pubService;
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

}
