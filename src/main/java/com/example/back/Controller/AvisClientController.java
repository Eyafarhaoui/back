package com.example.back.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.Model.AvisClient;
import com.example.back.Model.Proprietaire;
import com.example.back.Model.Reservation;
import com.example.back.Model.client;
import com.example.back.repository.AvisClientRepository;
import com.example.back.repository.ClientRepository;
import com.example.back.repository.ProprietaireRepository;
import com.example.back.repository.ReservationRepository;
import com.example.back.service.AvisClientService;

@RestController
@RequestMapping("/api/avis-client") 
public class AvisClientController { 

    @Autowired
    private AvisClientService avisClientService;

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProprietaireRepository proprietaireRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private AvisClientRepository avisClientRepository;

    @GetMapping("/proprietaire-id")
    public long getProprietaireIdByContenu(@RequestParam String contenu) {
        // Retourner un long primitif
        return avisClientService.getProprietaireIdByContenu(contenu);
    }
    

  
    @PostMapping
    public ResponseEntity<?> ajouterAvis(@RequestBody AvisClient avis) {
        if (avis.getClient() == null || avis.getClient().getId() == null) {
            return ResponseEntity.badRequest().body("Client non spécifié.");
        }
        if (avis.getProprietaire() == null || avis.getProprietaire().getId() == null) {
            return ResponseEntity.badRequest().body("Propriétaire non spécifié.");
        }
        if (avis.getReservation() == null || avis.getReservation().getId() == null) {
            return ResponseEntity.badRequest().body("Réservation non spécifiée.");
        }
    
        // Récupérer les entités validées
        client client = clientRepository.findById(avis.getClient().getId())
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        Proprietaire proprietaire = proprietaireRepository.findById(avis.getProprietaire().getId())
                .orElseThrow(() -> new RuntimeException("Propriétaire non trouvé"));
        Reservation reservation = reservationRepository.findById(avis.getReservation().getId())
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));
    
        avis.setClient(client);
        avis.setProprietaire(proprietaire);
        avis.setReservation(reservation);
    
        AvisClient nouvelAvis = avisClientRepository.save(avis);
        return ResponseEntity.ok(nouvelAvis);
    }
    
    @GetMapping("/{clientId}")
    public ResponseEntity<List<AvisClient>> getAvisParClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(avisClientService.getAvisParClient(clientId));
    }
}
