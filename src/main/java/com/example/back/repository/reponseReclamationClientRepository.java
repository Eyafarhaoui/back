package com.example.back.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.back.Model.ReponseReclamationClient;

@Repository
public interface reponseReclamationClientRepository extends JpaRepository<ReponseReclamationClient, Long>{
    
}
