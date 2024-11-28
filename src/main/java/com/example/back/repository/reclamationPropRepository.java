package com.example.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.Model.ReclamationProp;
import org.springframework.stereotype.Repository;


@Repository
public interface reclamationPropRepository  extends JpaRepository<ReclamationProp, Long> {
    
}
