package com.example.Movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.util.Map;

@RestController
@CrossOrigin(originPatterns = "http://localhost:3000")
@RequestMapping(value = "/meet",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class PatientController {

    @Autowired
    PatientService patientService ;



    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Map<String,String> payload) throws ParseException, GeneralSecurityException, IOException {
        return new ResponseEntity<Patient>(patientService.createPatient(payload.get("Name"),payload.get("Email"),payload.get("DoctorID"),payload.get("dateString"),payload.get("Service"),payload.get("Link"),payload.get("timeString")), HttpStatus.CREATED);
    }

    @PostMapping("/chat")
    public ResponseEntity<Map<String,String>> chatbot(@RequestBody Map<String,String> payload){
        return new ResponseEntity<Map<String,String>>(patientService.executePythonScript(payload.get("message")),HttpStatus.OK);
    }

}
