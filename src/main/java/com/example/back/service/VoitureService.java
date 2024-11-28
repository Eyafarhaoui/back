package com.example.back.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.example.back.Model.Voiture;
import com.example.back.repository.VoitureRepository;



@Service
public class VoitureService {
    @Autowired
    private VoitureRepository voitureRepository;

    public Voiture saveVoiture(Voiture voiture) {
        if (voiture == null) {
            throw new IllegalArgumentException("Voiture cannot be null");
        }

        
        
        
        System.out.println("Saving voiture: " + voiture);
        return voitureRepository.save(voiture);
    }
    public Voiture changerEtat(Voiture v) {
        // Retrieve the car from the repository by its ID
        Voiture voiture = voitureRepository.findById(v.getId())
                .orElseThrow(() -> new RuntimeException("Voiture non trouvée"));
    
        // Update the car's status to "payer"
        voiture.setEtat("paye");
    
        // Save the updated car status in the repository
        return voitureRepository.save(voiture);
    }
    

    public Voiture findById(Long id) {
        Optional<Voiture> voiture = voitureRepository.findById(id);
        return voiture.orElse(null); // Return the car if found, or null if not found
    }
    
    public List<Voiture> getAllVoitures() {
        return voitureRepository.findAllWithDisponibilites();
    }
  

    public Optional<Voiture> getVoitureById(Long id) {
        return voitureRepository.findById(id);
    }

}
