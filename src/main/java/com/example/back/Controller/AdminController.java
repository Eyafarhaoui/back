package com.example.back.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.Model.Agent;
import com.example.back.Model.pub;
import com.example.back.service.AgentService;
import com.example.back.service.EmailService;

import jakarta.annotation.security.PermitAll;
import jakarta.mail.internet.MimeMessage;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AgentService agentService;
    @Autowired
    private EmailService emailService;

    @PostMapping("/ajouter-agent")  // Simplification ici
    public ResponseEntity<Agent> ajouterAgent(@RequestBody Agent request) {
        System.out.println("Données reçues dans le contrôleur: " + request);
        Agent savedAgent = agentService.ajouterAgent(request.getUsername(), request.getPassword(),request.getEmail());
        String subject = "Bienvenue chez Elite Auto, cher agent !";
String body = "<html><body>"
    + "<p>Bonjour " + savedAgent.getUsername() + ",</p>"
    + "<p>Nous avons le plaisir de vous informer que votre compte a été créé avec succès !<br>"
    + "Pour vous connecter, veuillez utiliser votre nom d'utilisateur ainsi que votre mot de passe.</p>"
    + "<p><strong style='color:#0073e6;'>Votre nom d'utilisateur : " + request.getUsername() + "</strong></p>"

    + "<p><strong style='color:#0073e6;'>Votre mot de passe : " + request.getPassword() + "</strong></p>"
    + "<p>Nous vous souhaitons la bienvenue chez <strong>Elite Auto</strong>, et restons à votre disposition pour toute question.</p>"
    + "<p>Cordialement,<br>"
    + "L'équipe Elite Auto</p>"
    + "</body></html>";
    
        try{
             
            emailService.sendEmail(savedAgent.getEmail(), subject, body);
            System.out.println("Nom d'utilisateur : " + request.getUsername());
            System.out.println("Mot de passe : " + request.getPassword());
            System.out.println("Email : " + request.getEmail());

        }
        catch (Exception e) {
            System.out.println("Erreur lors de l'envoi de l'email: " + e.getMessage());
            return ResponseEntity.status(500).body(null); // Retourner une erreur si l'envoi échoue
        }
       


        return ResponseEntity.status(201).body(savedAgent);
    }


    
}
