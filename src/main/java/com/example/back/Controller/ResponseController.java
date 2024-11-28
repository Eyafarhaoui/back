package com.example.back.Controller;

import org.springframework.web.bind.annotation.*;

import com.example.back.Model.Response;
import com.example.back.service.ResponseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/Response")
public class ResponseController {

    @Autowired
    private ResponseService ResponseService;


    @PostMapping
    public ResponseEntity<Response> createresponse(@RequestBody Response Response) {
        System.out.println("Données reçues dans le contrôleur: " + Response);
        Response savedResponse = ResponseService.saveResponse(Response);
        return new ResponseEntity<>(savedResponse, HttpStatus.CREATED);
    }
    


    @GetMapping("/publication/{id}")
    public List<Response> getAllResponse() {
        return ResponseService.getAllResponse();
    }



    @GetMapping("/client/{id}")
public ResponseEntity<?> getResponsesByClientId(@PathVariable("id") Long id) {
    if (id == null) {
        return ResponseEntity.badRequest().body("ID cannot be null");
    }
    return ResponseEntity.ok(ResponseService.getResponseByIdClient(id));
}

}