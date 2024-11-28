package com.example.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.back.Model.AvisProprietaire;

@Repository
public interface AvisProprietaireRepository  extends JpaRepository<AvisProprietaire, Long> {
    List<AvisProprietaire> findByProprietaireId(Long ProprietaireId);
    
}