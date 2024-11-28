package com.example.back.repository;

import com.example.back.Model.Disponibilite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisponibiliteRepository extends JpaRepository<Disponibilite, Long> {
    // Méthode pour récupérer les disponibilités d'une voiture spécifique
    List<Disponibilite> findByVoitureId(Long voitureId);
}


