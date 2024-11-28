package com.example.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.back.Model.ReclamationClient;

@Repository
public interface ReclamationClientRepository extends JpaRepository<ReclamationClient, Long> {

}
