package com.AHE.CRUDbck.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private  String firstName;


    @Column(name = "last_name")
    private  String lasttName;

    @Column(name = "email_id")
    private  String emailID;

    public Employee() {
    }

    public Employee(Long id, String firstName, String lasttName, String emailID) {
        this.id = id;
        this.firstName = firstName;
        this.lasttName = lasttName;
        this.emailID = emailID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasttName() {
        return lasttName;
    }

    public void setLasttName(String lasttName) {
        this.lasttName = lasttName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }
}
