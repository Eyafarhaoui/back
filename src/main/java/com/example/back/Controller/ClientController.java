package com.example.back.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.back.Model.client;
import com.example.back.repository.ClientRepository;
import com.example.back.service.ClientService;

import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;
   @Autowired
    private ClientService clientService;

    @PostMapping("/login")
    public ResponseEntity<?> loginOrRegisterClient(@RequestBody client client) {
        Optional<client> existingClient = clientRepository.findByEmail(client.getEmail());

        if (existingClient.isPresent()) {
            return ResponseEntity.ok(existingClient.get());
        } else {
            client savedClient = clientRepository.save(client);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
        }
        
    }
 @GetMapping("/{id}")
    public ResponseEntity<client> getClientById(@PathVariable Long id) {
        Optional<client> client = clientService.getClientById(id);

        if (client.isPresent()) {
            return ResponseEntity.ok(client.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
