package com.example.contact_generator.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;// to make the entity read-only with Hibernate(optional)

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Immutable
@Entity
@Table(name="contacts")
public class Employee {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone") // it should be phone_no for the main app
    private String phoneNo;

    @Column(name = "phone_no_two")
    private String phoneNoTwo;

    @Column(name = "phone_no_three")
    private String phoneNoThree;


    public String getFullName() {
        return String.join(" ",
                firstName != null ? firstName : "",
                middleName != null ? middleName : "",
                lastName != null ? lastName : ""
        ).trim().replaceAll("\\s+", " ");
    }
}
