package com.example.back.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class client {
  
   @Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
@SequenceGenerator(name = "client_seq", sequenceName = "client_sequence", allocationSize = 1)
private Long id;

   

    private String name;
    private String email;
    
    private String profilePicture; 
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getProfilePicture() {
        return profilePicture;
    }
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

}
