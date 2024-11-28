package com.example.back.Model;
import jakarta.persistence.*;

@Entity
public class ReponseReclamationClient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resrecC_seq_gen")
    @SequenceGenerator(name = "resrecC_seq_gen", sequenceName = "resrecC_seq", allocationSize = 1)
    private Long id;

    
    private String contenu;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    
}
