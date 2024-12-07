package com.example.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.back.Model.ReponseSurAvisClient;
import com.example.back.Model.ReponseSurAvisProp;

@Repository
public interface ReponseSurAvisClientRepository extends JpaRepository<ReponseSurAvisClient, Long> {
    // Vous pouvez ajouter des méthodes de requêtes personnalisées ici si nécessaire
    List<ReponseSurAvisClient> findByContenuAvisAndClientId(String contenuAvis, Long clientId);
}
