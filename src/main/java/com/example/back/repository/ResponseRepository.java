package com.example.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.back.Model.Response;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {
    List<Response>  findByIdClient(Long idClient);}
    