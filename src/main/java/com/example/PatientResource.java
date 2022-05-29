package com.example;

import com.example.models.Patient;
import com.example.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Patient")
public class PatientResource {
    private  final PatientService patientService;


    public PatientResource(PatientService patientService) {
        this.patientService = patientService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllPatient(){
        List<Patient> patients=PatientService.findAllPatients();
        return  new ResponseEntity<>(patients, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") Long id){
        Patient patient=PatientService.findPatientById(id);
        return  new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient ){
       Patient newpatient=patientService.addPatient(patient);
        return  new ResponseEntity<>(newpatient, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient ){
        Patient updatepatient=patientService.updatePatient(patient);
        return  new ResponseEntity<>(updatepatient, HttpStatus.OK);

    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable("id") Long id){
       patientService.deletePatient(id);
        return  new ResponseEntity<>( HttpStatus.OK);

    }



}
