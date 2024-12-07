package com.example.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.back.Model.Agent;
import com.example.back.Model.pub;
import com.example.back.repository.AgentRepository;

@Service
public class AgentService {
    @Autowired
    private AgentRepository agentRepository;

 



    public Agent ajouterAgent(String username, String password,String email) {
        // Vérifier si un agent avec le même username existe déjà
        System.out.println("Vérification de l'existence de l'agent...");
        if (agentRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Un agent avec ce nom d'utilisateur existe déjà.");
        }

        // Hacher le mot de passe
        Agent agent = new Agent();
        agent.setUsername(username);
        agent.setPassword(password);
        agent.setEmail(email);
        System.out.println("Agent créé: " + agent);
        return agentRepository.save(agent);
    }
     
    
}
