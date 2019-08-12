package com.example.demo.repos;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SiteUser {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private String gender;
    private String city;
    private Date dateOfBirth;

    private Date dateOfEvent;

    @Column(length = 4000)
    private String recommendations;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() { return gender; }

    public void setCity(String city){this.city=city;}

    public String getCity(){return city;}

    public void setGender(String gender) { this.gender = gender; }

    public Date getDateOfEvent(){return dateOfEvent;}

    public void setDateOfEvent(Date dateOfEvent) { this.dateOfEvent = dateOfEvent; }

    public String getRecommendations() { return recommendations; }

    public void setRecommendations(String recommendations) { this.recommendations = recommendations; }
}
