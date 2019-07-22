package com.example.demo.controlles;

import com.example.demo.Car;
import com.example.demo.repos.CarRepository;
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

    @Autowired
    private CarRepository carRepository;

    @PostConstruct
    private void init() {

    }

    public String getPhone() { return phone; }

    public String getEmail() { return email; }

    public String getKod() { return kod; }

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

    public String Registration() { return "registration.xhtml?faces-redirect=true"; }
    public String Home() { return "mainPage.xhtml?faces-redirect=true"; }

public void saveCar(){
        Car car=new Car();
        car.setName("toyota");
        car.getDate(new Date());
        car.setNum(555);
        carRepository.save(car);

}
    public void sayHello2() {
        System.out.println("Hello1 " + name + " " + surname);
    }
}
