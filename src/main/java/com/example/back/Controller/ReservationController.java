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

import com.example.back.Model.Reservation;
import com.example.back.service.ReservationService;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/create")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation createdReservation = reservationService.createReservation(reservation);
        return ResponseEntity.ok(createdReservation);
    }

    
     @GetMapping
    public List<Reservation> getReservationsByClientId(@RequestParam Long clientId) {
        return reservationService.getReservationsByClientId(clientId);
    }
     @GetMapping("/proprietaire/{proprietaireId}")
    public List<Reservation> getReservationsByProprietaireId(@PathVariable Long proprietaireId) {
        return reservationService.findReservationsByProprietaireId(proprietaireId);
    }
}
