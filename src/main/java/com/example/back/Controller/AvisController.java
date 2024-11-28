package com.example.back.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<?> getAvisByProprietaire(@PathVariable("id") Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().body("ID cannot be null");
        }
        return ResponseEntity.ok(avisService. getAvisByProprietaire(id));
    }
    @GetMapping("/client/{id}")
    public ResponseEntity<?> getAvisByClient(@PathVariable("id") Long id) {
        if (id  == null) {
            return ResponseEntity.badRequest().body("ID cannot be null");
        }
        return ResponseEntity.ok(avisService.getAvisByClient(id));
    }
    


}

