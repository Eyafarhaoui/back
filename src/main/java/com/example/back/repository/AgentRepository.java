package com.example.back.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.back.Model.Agent;


@Repository
public interface AgentRepository extends JpaRepository<Agent, Long>{
    Optional<Agent> findByUsername(String username);
}
    

