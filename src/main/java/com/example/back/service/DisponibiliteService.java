package com.example.back.service;

import com.example.back.Model.Disponibilite;
import com.example.back.repository.DisponibiliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisponibiliteService {
    @Autowired
    private DisponibiliteRepository disponibiliteRepository;

    public List<Disponibilite> saveAll(List<Disponibilite> t){
        return disponibiliteRepository.saveAll(t);
    }

    public Disponibilite saveDisponibilite(Disponibilite disponibilite) {
        return disponibiliteRepository.save(disponibilite);
    }

    public List<Disponibilite> getDisponibilitesByVoitureId(Long voitureId) {
        return disponibiliteRepository.findAll(); // Remplacez par une requête spécifique si nécessaire
    }

    public void deleteDisponibilite(Long id) {
        disponibiliteRepository.deleteById(id);
    }
}



