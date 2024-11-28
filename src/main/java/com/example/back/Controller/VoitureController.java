package com.example.back.Controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.back.Model.Disponibilite;
import com.example.back.Model.Voiture;
import com.example.back.Model.VoitureDTO;
import com.example.back.service.DisponibiliteService;
import com.example.back.service.FileStorageService;
import com.example.back.service.VoitureService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/voitures")
public class VoitureController {
    @Autowired
    private VoitureService voitureService;
    
    @Autowired
    private FileStorageService fileStorageService;
   
        @Autowired
    private DisponibiliteService disponibiliteService;
    
    @PostMapping()//consumes = MediaType.MULTIPART_FORM_DATA_VALUE)

    public ResponseEntity<?> createVoiture(@RequestBody Voiture voiture
                                                // @RequestParam("imageFile") MultipartFile imageFile
                                                 ) {
                                                    List<Disponibilite> t = voiture.getDisponibilites();
                                                    
                                                    //this.voitureService.saveVoiture(voiture);
                                                    for ( Disponibilite d : t ){
                                                        d.setVoiture(voiture);
                                                        //disponibiliteService.saveDisponibilite(d);
                                                    }

                                                    //this.disponibiliteService.saveAll(t);
                                                     return ResponseEntity.status(HttpStatus.CREATED).body(t);
                                                     
        /* 
                                                    try {
            // Deserialize JSON to Voiture
            ObjectMapper objectMapper = new ObjectMapper();
            Voiture voiture = objectMapper.readValue(voitureJson, Voiture.class);
    
            if (voiture == null ){//|| imageFile.isEmpty()) {
                System.out.println("azertyu");
                return ResponseEntity.badRequest().build();  // Return 400 if invalid data
            }
    
            // Store image and set path
            /*
            String imagePath = fileStorageService.storeFile(imageFile);
            voiture.setImagePath(imagePath);
    */
            // Save voiture
            /*
            Voiture createdVoiture = voitureService.saveVoiture(voiture);
    
            if (voiture.getDisponibilites() != null && !voiture.getDisponibilites().isEmpty()) {
                for (Disponibilite disponibilite : voiture.getDisponibilites()) {
                    disponibilite.setVoiture(createdVoiture);
                    disponibiliteService.saveDisponibilite(disponibilite);
                }
            }
    
            return ResponseEntity.status(HttpStatus.CREATED).body(createdVoiture);
    
        
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }*/
    }
    
    @GetMapping
    public List<Voiture> getAllVoitures() {
        return voitureService.getAllVoitures();
    }
   /*  @GetMapping("/{id}")
    public ResponseEntity<Voiture> getVoitureById(@PathVariable Long id) {
        Voiture voiture = voitureService.findById(id);
        if (voiture != null) {
            return ResponseEntity.ok(voiture);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    @PutMapping("/{id}/changeretat")
public ResponseEntity<Voiture> changerEtat(@PathVariable Long id) {
    // Retrieve the car by its ID from the service
    Voiture voiture = voitureService.findById(id);
    
    
    // Call the service to change the car's state to "payer"
    Voiture updatedVoiture = voitureService.changerEtat(voiture);
    System.out.println("Updated car state: " + updatedVoiture.getEtat()); 

    // Return the updated car with status 200 OK
    return ResponseEntity.ok(updatedVoiture);
}

    @GetMapping("/{id}")
public ResponseEntity<VoitureDTO> getVoitureById(@PathVariable Long id) {
    Voiture voiture = voitureService.findById(id);
    if (voiture != null) {
        VoitureDTO voitureDTO = new VoitureDTO(voiture);
        return ResponseEntity.ok(voitureDTO);
    } else {
        return ResponseEntity.notFound().build();
    }
}


    @PostMapping("/add")
    public ResponseEntity<?> test(@RequestBody Voiture v) {
        
         for ( Disponibilite d : v.getDisponibilites()){
            d.setVoiture(v);
        }

        Voiture v2 = this.voitureService.saveVoiture(v);
        
       for ( Disponibilite d : v2.getDisponibilites()){
           this.disponibiliteService.saveDisponibilite(d);
        }

        return ResponseEntity.ok(v2.getId());
    }

    @PostMapping("/image/{id}")
    public ResponseEntity<?> test2Entity(@RequestParam("imageFile") MultipartFile imageFile,@PathVariable Long id) throws IOException {
        Voiture v = this.voitureService.findById(id);
        v.setImageVoiture(imageFile.getBytes()); 
        this.voitureService.saveVoiture(v);
        return ResponseEntity.ok(Boolean.TRUE) ;
    }

    @GetMapping("/getImage/{id}")
    public ResponseEntity<byte[]> telechargerImage(@PathVariable Long id){
        Voiture v = this.voitureService.findById(id);
        
        if (v!= null){
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            headers.setContentDispositionFormData("attachment", v.getImagePath());
            return new ResponseEntity<>(v.getImageVoiture(), headers, HttpStatus.OK);
        }
        return null;
    }

    
}