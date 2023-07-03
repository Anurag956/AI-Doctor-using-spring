package com.example.Movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public Patient createPatient(String Name,String Email, String DoctorID ,String dateString,String Service,String Link,String timeString) throws ParseException {
        Patient patient = patientRepository.insert(new Patient(Name,Email,DoctorID,dateString,Service,Link,timeString));

        return patient;
    }

    public Map<String, String> executePythonScript(String argument) {
        try {
            String pythonScript = "C:\\Users\\Sandeep\\Downloads\\Demo Project Java Spring Boot\\Movies\\bard.py";
            ProcessBuilder processBuilder = new ProcessBuilder("python", pythonScript, argument);
            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                Map<String, String> response = new HashMap<>();
                response.put("chat", output.toString());
                return response;
            } else {
                Map<String, String> response = new HashMap<>();
                response.put("error", "Script execution failed with exit code: " + exitCode);

                return response;
            }
        } catch (IOException | InterruptedException e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "An error occurred while executing the Python script.");

            return response;
        }
    }


}
