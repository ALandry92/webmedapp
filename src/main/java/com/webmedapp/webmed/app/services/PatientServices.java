package com.webmedapp.webmed.app.services;

import java.util.List;
import java.util.Optional;

import com.webmedapp.webmed.app.model.Patients;

public interface PatientServices {

    Optional<Patients> findById(Long id);

    Optional<Patients> findByEmail(String email);

    Optional<Patients> login(String email, String password);

    Optional<Patients> findById(String id);

    List<Patients> findByName(String name);

    List<Patients> findAll();

    void delete(Long id);

    void updateUser(Patients patient);

    void updateRole(String role, Long id);

    void resetpassword(String password, Long id);

    void save(Patients patient);
}
