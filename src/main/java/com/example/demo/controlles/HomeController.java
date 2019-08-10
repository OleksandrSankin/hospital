package com.example.demo.controlles;

import com.example.demo.Car;
import com.example.demo.repos.CalendarView;
import com.example.demo.repos.CarRepository;
import com.example.demo.repos.SiteUser;
import com.example.demo.repos.UserRepository;
import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.Date;
import java.util.List;

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

    private String newPassword1;

    private String newPassword2;


    private boolean skip;


    @Autowired
    private UserRepository userRepository;


    @PostConstruct
    private void init() {
        List<SiteUser> all = userRepository.findAll();

        for (int i = 0; i < all.size(); i++) {
            SiteUser siteUser = all.get(i);
            if (siteUser.getName().equals(name)) {
                email = siteUser.getEmail();
                name = siteUser.getName();
                surname = siteUser.getSurname();
                date = siteUser.getDateOfBirth();
                city = siteUser.getCity();
                gender = siteUser.getGender();

                break;
            }
        }
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

    public String getNewPassword1() {
        return newPassword1;
    }

    public void setNewPassword1(String newPassword1) {
        this.newPassword1 = newPassword1;
    }

    public String getNewPassword2() {
        return newPassword2;
    }

    public void setNewPassword2(String getNewPassword2) {
        this.newPassword2 = newPassword2;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String Registration()
    {
        setPhone(this.phone);
        return "registration.xhtml?faces-redirect=true";
    }

    public String Home() {
        return "mainPage.xhtml?faces-redirect=true";
    }

    public String UserPage() {
        saveUser();
        return "userPage.xhtml?faces-redirect=true";
    }

    public String ChangeSomeInformation() {
        return "changeSomeInformation.xhtml?faces-redirect=true";
    }

    public void PositiveAnswer() {
        addMessage("Готово", "Данные сохранены");
        saveUser();
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void SetNewUserPassword() {
        if (getNewPassword1() == getNewPassword2()) {
            password = newPassword1;
        } else {
        }
    }



    public void saveUser() {
        SiteUser siteUser = new SiteUser();
        siteUser.setName(this.name);
        siteUser.setSurname(this.surname);
        siteUser.setEmail(this.email);
        siteUser.setDateOfBirth(this.date);
        siteUser.setGender(this.gender);
        siteUser.setCity(this.city);
        siteUser.setPassword(this.password);
        siteUser.setPhone(this.phone);

        userRepository.save(siteUser);
    }


    //    --------------
    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }


    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }
}
