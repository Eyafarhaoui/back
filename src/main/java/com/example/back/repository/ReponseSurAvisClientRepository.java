package com.example.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.back.Model.ReponseSurAvisClient;

@Repository
public interface ReponseSurAvisClientRepository extends JpaRepository<ReponseSurAvisClient, Long> {
    // Vous pouvez ajouter des méthodes de requêtes personnalisées ici si nécessaire
}
