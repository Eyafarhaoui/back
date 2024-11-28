package com.example.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.back.Model.client;
import com.example.back.repository.ClientRepository;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Optional<client> getClientById(Long id) {
        return clientRepository.findById(id);
    }
}

