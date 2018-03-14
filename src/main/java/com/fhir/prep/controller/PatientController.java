package com.fhir.prep.controller;

import com.fhir.prep.util.RestHelper;
import org.hl7.fhir.dstu3.model.Patient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PatientController {

/*    @RequestMapping("/patient")
    public Patient getPatients(Integer days){
        Patient patient = new Patient();
       // patient.setFirstName("Mohan");
        //patient.setLastName("Gudey");
        return patient;
    }*/

   @RequestMapping("/patient")
    public String getPatientById(@RequestParam(value="id") Integer id){
        Patient patient = RestHelper.get().read().resource(Patient.class).withId(String.valueOf(id)).execute();
        return patient.getNameFirstRep().getNameAsSingleString();
    }

}
