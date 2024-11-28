package com.example.back.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.back.Model.pub;
import com.example.back.repository.pubRepository;

@Service
public class pubService {
    @Autowired
    private pubRepository pubRepository;

    public pub savepub(pub pub) {
        if (pub == null) {
            throw new IllegalArgumentException("pub cannot be null");
        }
        System.out.println("ID du client avant sauvegarde: " + pub.getIdClient());
        System.out.println("Saving pub: " + pub);
        return pubRepository.save(pub);
    }
  


    public pub findById(Long id) {
        Optional<pub> pub = pubRepository.findById(id);
        return pub.orElse(null); 
    }

    public List<pub> getAllpub() {
        return pubRepository.findAll();
    }
}


