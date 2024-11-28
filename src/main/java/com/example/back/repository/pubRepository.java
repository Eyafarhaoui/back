package com.example.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.back.Model.pub;

@Repository
public interface pubRepository extends JpaRepository<pub, Long> {
    
}
       

