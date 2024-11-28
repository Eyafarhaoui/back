package com.example.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.back.Model.Voiture;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Long> {

    @Query("SELECT v FROM Voiture v LEFT JOIN FETCH v.disponibilites")
    List<Voiture> findAllWithDisponibilites();
}


