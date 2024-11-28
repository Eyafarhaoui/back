package com.example.back.Model;
import jakarta.persistence.*;

@Entity
public class ReponseReclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resrec_seq_gen")
    @SequenceGenerator(name = "resrec_seq_gen", sequenceName = "resrec_seq", allocationSize = 1)
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
    

