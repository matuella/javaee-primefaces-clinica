/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.controller;

import com.gmatuella.clinic.entity.Doctor;
import com.gmatuella.clinic.entity.Pacient;
import com.gmatuella.clinic.entity.Secretary;
import com.gmatuella.clinic.exception.GenericServiceException;
import com.gmatuella.clinic.service.DoctorService;
import com.gmatuella.clinic.service.PacientService;
import com.gmatuella.clinic.service.SecretaryService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author gmatuella
 */
@Named
@RequestScoped
public class HelperBean {
    
    public HelperBean() {
    }

    public List<String> completeText(String query) {
        List<String> results = new ArrayList();
//        PacienteService service = new PacienteService(new ClinicaEntityManager("ClinicaPU"));
//        for (Paciente p : service.findAll()) {
//            if((p.getNome().toLowerCase()).contains(query.toLowerCase())){
//                results.add(p.getNome());
//            }
//        }
        List<Pacient> listaTeste = new ArrayList();
//        listaTeste.add(new Paciente(1L, "Teste 1", "51515151"));
//        listaTeste.add(new Paciente(2L, "Aeste 1", "51515151"));
//        listaTeste.add(new Paciente(3L, "Oreste 1", "51515151"));
//        listaTeste.add(new Paciente(4L, "Moleque 1", "51515151"));
        for (Pacient p : listaTeste) {
            if ((p.getName().toLowerCase()).contains(query.toLowerCase())) {
                results.add(p.getName());
            }
        }
        if (results.isEmpty()) {
            results.add("Pacient not found!");
        }
        return results;
    }

    public String redirectLogin() {
        return "login.xhtml?faces-redirect=true";
    }

    public String redirectDashboard() {
        return "dashboard.xhtml?faces-redirect=true";
    }

    public String redirectAppointments() {
        return "appointments.xhtml?faces-redirect=true";
    }

    public String redirectAnalytics() {
        return "analytics.xhtml?faces-redirect=true";
    }

    public String generateDoctors() throws GenericServiceException {
        for (int i = 0; i < 10; i++) {
            int randomValue = new Random().nextInt(99999);
            Doctor medTeste = new Doctor();
            medTeste.setName("Med " + randomValue);
            medTeste.setPhone("(51) 444" + randomValue);
            medTeste.setAddress("Av. Teste" + randomValue);
            medTeste.setLogin("med" + randomValue);
            medTeste.setPassword("med" + randomValue);
            medTeste.setStatus(true);
            medTeste.setSpecialties("Psicologia" + randomValue);
            new DoctorService().save(medTeste);
        }
        return "dashboard.xhtml?faces-redirect=true";
    }

    public String generatePacients() throws GenericServiceException {
        for (int i = 0; i < 10; i++) {
            int randomValue = new Random().nextInt(99999);
            Pacient pacTeste = new Pacient();
            pacTeste.setName("Pac " + randomValue);
            pacTeste.setPhone("(51) 777" + randomValue);
            pacTeste.setAddress("Av. Test" + randomValue);
            pacTeste.setBirthDate(LocalDate.now());
            new PacientService().save(pacTeste);
        }
        return "dashboard.xhtml?faces-redirect=true";
    }

    public String generateSecretaries() throws GenericServiceException {
        for (int i = 0; i < 10; i++) {
            int randomValue = new Random().nextInt(99999);
            Secretary secTeste = new Secretary();
            secTeste.setName("Sec " + randomValue);
            secTeste.setPhone("(51) 777" + randomValue);
            secTeste.setAddress("Av. Test" + randomValue);
            secTeste.setLogin("sec" + randomValue);
            secTeste.setPassword("sec" + randomValue);
            secTeste.setStatus(true);
            new SecretaryService().save(secTeste);
        }
        return "dashboard.xhtml?faces-redirect=true";
    }
}
