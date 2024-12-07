package com.example.back.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.back.Model.AvisClient;
import com.example.back.Model.AvisProprietaire;

@Repository
public interface AvisProprietaireRepository  extends JpaRepository<AvisProprietaire, Long> {
    List<AvisProprietaire> findByProprietaireId(Long ProprietaireId);
    List<AvisProprietaire> findByClientId(Long ClientId);
    Optional<AvisProprietaire> findByContenu(String contenu);

  

    
}