package com.example.back.Controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.back.Model.Voiture;
import com.example.back.service.VoitureService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class ImageController {

    @Value("${images.upload-dir:C:/Users/tabar/Desktop/pi}")
    private String uploadDir;



    @Autowired
    private VoitureService vs;



    // Modifiez le chemin ici pour inclure le nom du fichier
    @GetMapping("/images/{filename}")
public ResponseEntity<Resource> getImage(@PathVariable String filename) {
    try {
        Path file = Paths.get(uploadDir).resolve(filename);
        Resource resource = new UrlResource(file.toUri());

        if (resource.exists() || resource.isReadable()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

    @GetMapping("/images/{idVoiture}")
    public ResponseEntity<?> testImage(@PathVariable Long idVoiture) {
        Voiture v = vs.getVoitureById(idVoiture).get(); 
        String filename= v.getImagePath();
       
        
        return ResponseEntity.ok(filename);
            /*Path file = Paths.get(uploadDir).resolve(filename);
            Resource resource = new UrlResource(file.toUri());


            System.out.println("***********************************************************************************"+file.toString());
            return ResponseEntity.ok(this.uploadDir+""+filename);
/*
            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
       *-*/ 
        //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        
    }




}
