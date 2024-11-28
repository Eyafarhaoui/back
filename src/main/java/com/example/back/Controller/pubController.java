package com.example.back.Controller;

import org.springframework.web.bind.annotation.*;
import com.example.back.Model.pub;
import com.example.back.service.pubService;

import jakarta.transaction.Transactional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/pub")
public class pubController {

    @Autowired
    private pubService pubService;
    

    @PostMapping
    public ResponseEntity<pub> createPub(@RequestBody pub pub) {
        System.out.println("Données reçues dans le contrôleur: " + pub);
        pub savedPub = pubService.savepub(pub);
        return new ResponseEntity<>(savedPub, HttpStatus.CREATED);
    }

    @Transactional
    @GetMapping
    public List<pub> getAllpub() {
        return pubService.getAllpub();
    }
}
