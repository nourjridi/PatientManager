package com.example.service;

import com.example.exception.UserNotFoundException;
import com.example.models.Patient;
import com.example.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {
    private static  PatientRepo patientRepo;

    @Autowired
    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }
    public Patient addPatient(Patient patient){
         patient.setId(Long.parseLong(UUID.randomUUID().toString()));
         return patientRepo.save(patient);

    }
    public static List<Patient> findAllPatients(){
        return  patientRepo.findAll();
    }
    public Patient updatePatient(Patient patient){
        return patientRepo.save(patient);
    }
    public static Patient findPatientById(Long id){
        return  patientRepo.findPatientById(id)
                .orElseThrow(() -> new UserNotFoundException("le patient avec id "+id+"n est pas trouvé"));
    }
   public  void deletePatient(Long id){
        patientRepo.deletePatientById(id);
   }


}
