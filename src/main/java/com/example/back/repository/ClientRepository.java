package com.example.back.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.back.Model.client;

@Repository
public interface ClientRepository extends JpaRepository<client, Long> {
    Optional<client> findByEmail(String email);
}


