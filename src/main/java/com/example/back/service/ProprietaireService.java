package com.example.back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.back.Model.Proprietaire;
import com.example.back.repository.ProprietaireRepository;

@Service
public class ProprietaireService {
    @Autowired
    private ProprietaireRepository proprietaireRepository;

    public Proprietaire saveProprietaire(Proprietaire proprietaire) {
        return proprietaireRepository.save(proprietaire);
    }

    public List<Proprietaire> getAllProprietaires() {
        return proprietaireRepository.findAll();
    }
    public List<Proprietaire> findByTelephone(String telephone) {
        return proprietaireRepository.findByTelephone(telephone);
    }
    public Optional<Proprietaire> getProprietaireById(Long proprietaireIds) {
        return proprietaireRepository.findById(proprietaireIds);
    }

    

    
    
}

