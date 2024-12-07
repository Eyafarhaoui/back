package com.example.back.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.Model.AvisDto;
import com.example.back.service.AvisClientService;
import com.example.back.service.AvisService;


@RestController
@RequestMapping("/api/avis")
public class AvisController {

    @Autowired
    private AvisService avisService;
    @GetMapping("/proprietaire/{id}")
    //avis fait par proprietaire x 
    public ResponseEntity<?> getAvisFaitsParProprietaire(@PathVariable("id") Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().body("ID cannot be null");
        }
        return ResponseEntity.ok(avisService.getAvisFaitsParProprietaire(id));
    }

    @GetMapping("/client/{id}")
    //avis fait par proprietaire x 
    public ResponseEntity<?> getAvisFaitsParClient(@PathVariable("id") Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().body("ID cannot be null");
        }
        return ResponseEntity.ok(avisService.getAvisFaitsParClient(id));
    }
    @GetMapping("/avis-client/{id}")
    public ResponseEntity<?> getAvisByClient(@PathVariable("id") Long id) {
        if (id  == null) {
            return ResponseEntity.badRequest().body("ID cannot be null");
        }
        return ResponseEntity.ok(avisService.getAvisByClient(id));
    }
    @GetMapping("/avis-proprietaire/{id}")
    public ResponseEntity<?> getAvisByProprietaire(@PathVariable("id") Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().body("ID cannot be null");
        }
        try {
            return ResponseEntity.ok(avisService.getAvisByProprietaire(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }


}

