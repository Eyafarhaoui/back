package com.example.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.back.Model.ReponseReclamation;

@Repository
public interface ReponseReclamationRepository extends JpaRepository<ReponseReclamation, Long> {
}
