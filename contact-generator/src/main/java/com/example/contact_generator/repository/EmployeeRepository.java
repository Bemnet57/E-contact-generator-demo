package com.example.contact_generator.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.contact_generator.entity.Employee;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    Optional<Employee> findByEmail(String email);

//    List<Employee> findByFullNameContainingIgnoreCase(String fullName);
    //List<Employee> findByFirstNameContainingIgnoreCase(String firstName);
    List<Employee> findByFirstNameContainingIgnoreCaseOrMiddleNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
            String firstName,
            String middleName,
            String lastName
    );

    Optional<Employee> findByPhoneNo(String phoneNo);
}






