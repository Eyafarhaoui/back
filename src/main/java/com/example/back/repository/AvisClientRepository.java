package com.example.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.back.Model.AvisClient;

@Repository
public interface AvisClientRepository extends JpaRepository<AvisClient, Long> {
    List<AvisClient> findByClientId(Long clientId);
}
