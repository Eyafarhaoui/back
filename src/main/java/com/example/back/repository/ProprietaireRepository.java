package com.example.back.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.back.Model.Proprietaire;

@Repository
public interface ProprietaireRepository extends JpaRepository<Proprietaire, Long> {
    // Spring Data JPA génère automatiquement l'implémentation
    List<Proprietaire> findByTelephone(String telephone);
}


  