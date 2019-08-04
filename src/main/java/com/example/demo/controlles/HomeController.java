package com.example.demo.controlles;

import com.example.demo.Car;
import com.example.demo.repos.CarRepository;
import com.example.demo.repos.SiteUser;
import com.example.demo.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.Date;

@Named
public class HomeController {

    private String name;

    private String surname;

    private String phone;

    private String email;

    private String kod;

    private String gender;

    private String city;

    private Date date;

    private String password;

//    @Autowired //=new CarRepository()  odkaz na exemplar daneho classu
//    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;


    @PostConstruct
    private void init() {

    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getKod() {
        return kod;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String Registration() {
        return "registration.xhtml?faces-redirect=true";
    }

    public String Home() {
        return "mainPage.xhtml?faces-redirect=true";
    }

    public String UserPage(){
        return "userPage.xhtml?faces-redirect=true";
    }

//    public void saveCar() {
//        Car car = new Car();
//        car.setName("toyota");
//        car.getDate(new Date());
//        car.setNum(555);
//        carRepository.save(car);
//
//    }

    public void saveUser() {
        SiteUser siteUser = new SiteUser();
        siteUser.setName(this.name);
        siteUser.setSurname(this.surname);
        siteUser.setEmail(this.email);
        siteUser.setDateOfBirth(this.date);
        siteUser.setGender(this.gender);
        siteUser.setCity(this.city);
        siteUser.setPassword(this.password);

        userRepository.save(siteUser);
    }

}
