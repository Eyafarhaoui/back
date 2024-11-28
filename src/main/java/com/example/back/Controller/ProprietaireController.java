package com.example.back.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.Model.Proprietaire;
import com.example.back.service.ProprietaireService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/proprietaires")
public class ProprietaireController {
    @Autowired
    private ProprietaireService proprietaireService;

    @PostMapping
    public ResponseEntity<Map<String, String>> createProprietaire(@RequestBody Proprietaire proprietaire) {
        // Validation checks
        if (proprietaire.getNom() == null || proprietaire.getNom().isEmpty()) {
            return new ResponseEntity<>(Map.of("error", "Nom ne doit pas être vide."), HttpStatus.BAD_REQUEST);
        }
        if (proprietaire.getEmail() == null || proprietaire.getEmail().isEmpty()) {
            return new ResponseEntity<>(Map.of("error", "Email ne doit pas être vide."), HttpStatus.BAD_REQUEST);
        }
        if (proprietaire.getTelephone() == null || proprietaire.getTelephone().isEmpty()) {
            return new ResponseEntity<>(Map.of("error", "Téléphone ne doit pas être vide."), HttpStatus.BAD_REQUEST);
        }
        if (proprietaire.getPassword() == null || proprietaire.getPassword().isEmpty()) {
            return new ResponseEntity<>(Map.of("error", "Mot de passe ne doit pas être vide."), HttpStatus.BAD_REQUEST);
        }
        
        // Validate telephone number format and uniqueness
        if (!isTelephoneValid(proprietaire.getTelephone())) {
       
            return new ResponseEntity<>(Map.of("error", "Le numéro de téléphone doit contenir exactement 8 chiffres."), HttpStatus.BAD_REQUEST);
        }
    
        List<Proprietaire> existingProprietaires = proprietaireService.findByTelephone(proprietaire.getTelephone());
        if (!existingProprietaires.isEmpty()) {
            return new ResponseEntity<>(Map.of("error", "Le numéro de téléphone est déjà utilisé."), HttpStatus.CONFLICT);
        }
    
        // Save the Proprietaire
        Proprietaire savedProprietaire = proprietaireService.saveProprietaire(proprietaire);
        return new ResponseEntity<>(Map.of("message", "Compte créé avec succès !"), HttpStatus.CREATED);
    }
    

// Method to validate telephone number
private boolean isTelephoneValid(String telephone) {
    return telephone != null && telephone.matches("^\\d{8}$");
}


    @GetMapping
    public List<Proprietaire> getAllProprietaires() {
        return proprietaireService.getAllProprietaires();
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginProprietaire(@RequestBody Map<String, String> loginRequest) {
        String telephone = loginRequest.get("telephone");
        String password = loginRequest.get("password");

        // Validate inputs
          
        if (telephone == null || telephone.isEmpty()) {
            return new ResponseEntity<>(Map.of("error", "Téléphone ne doit pas être vide."), HttpStatus.BAD_REQUEST);
        }
        if (password == null || password.isEmpty()) {
            return new ResponseEntity<>(Map.of("error", "Mot de passe ne doit pas être vide."), HttpStatus.BAD_REQUEST);
        }

        // Check if the telephone number exists
        List<Proprietaire> proprietaires = proprietaireService.findByTelephone(telephone);
        if (proprietaires.isEmpty()) {
            return new ResponseEntity<>(Map.of("error", "Numéro de téléphone ou mot de passe incorrect."), HttpStatus.UNAUTHORIZED);
        }

        Proprietaire proprietaire = proprietaires.get(0); // Get the first matching proprietor

        // Verify password (assuming you store passwords in plaintext, which is not recommended)
        // Consider using a secure hashing function for production (e.g., BCrypt)
        if (!proprietaire.getPassword().equals(password)) {
            return new ResponseEntity<>(Map.of("error", "Numéro de téléphone ou mot de passe incorrect."), HttpStatus.UNAUTHORIZED);
        }

        // Login successful, return success message or proprietor details as needed
        return new ResponseEntity<>(Map.of("message", "Connexion réussie !", "proprietaireId", String.valueOf(proprietaire.getId())), HttpStatus.OK);
    }

     @GetMapping("/{id}")
    public ResponseEntity<?> getProprietaireById(@PathVariable Long id) {
        Optional<Proprietaire> proprietaire = proprietaireService.getProprietaireById(id);
        if (proprietaire.isPresent()) {
            return new ResponseEntity<>(proprietaire.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Map.of("error", "Propriétaire non trouvé"), HttpStatus.NOT_FOUND);
        }
    }
    
  

}

