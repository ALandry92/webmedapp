package com.webmedapp.webmed.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.webmedapp.webmed.app.model.Patients;

public interface PatientRepository extends JpaRepository<Patients, Long> {

    Optional<Patients> findByEmail(String email);

    // Old query will test in future
    // @Query("FROM Patients u WHERE u.email =?1 AND u.password = ?2)
    Optional<Patients> login(String email, String password);

    List<Patients> findByFname(String fname);

    void deleteById(Long id);

    Optional<Patients> findById(String email);

    Optional<Patients> findById(Optional<Patients> Optional);

}
