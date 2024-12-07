package com.example.back.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.Model.Agent;
import com.example.back.repository.AgentRepository;

import java.util.Map;

@RestController
@RequestMapping("/api") 
public class LoginAgent {

    @Autowired
    private AgentRepository agentRepository;

    @PostMapping("/login-agent")
    public ResponseEntity<?> login(@RequestBody Agent request) {
        // Recherche de l'agent par son nom d'utilisateur
        Agent agent = agentRepository.findByUsername(request.getUsername())
                .orElse(null);

        if (agent == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Agent non trouvé"));
        }

        // Vérification du mot de passe
        if (!agent.getPassword().equals(request.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Nom d'utilisateur ou mot de passe incorrect"));
        }

        // Si l'authentification est réussie
        return ResponseEntity.ok(Map.of("message", "Connexion réussie !"));
    }
}
