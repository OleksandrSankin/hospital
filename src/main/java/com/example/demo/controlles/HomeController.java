package com.example.demo.controlles;

import com.example.demo.Car;
import com.example.demo.repos.CalendarView;
import com.example.demo.repos.CarRepository;
import com.example.demo.repos.SecurityRole;
import com.example.demo.repos.SiteUser;
import com.example.demo.repos.UserRepository;
import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
public class HomeController {
    private List <SiteUser> userInformation=new ArrayList<>();

    private String name;

    private String surname;

    private String phone;

    private String email;

    private String kod;

    private String gender;

    private String city;

    private Date date;

    private String password;

    private String text;

    private Date dateOfEvent;
    private String recommendations;

    private String newPassword1;

    private String newPassword2;


    private boolean skip;


    @Autowired
    private UserRepository userRepository;


    @PostConstruct
    private void init() {
        createAdminUserIfNotExists();

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(Date dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public List<SiteUser> getUserInformation() {
        userInformation=userRepository.findAll();
        return userInformation;
    }

    public void setUserInformation(List<SiteUser> userInformation) {
        this.userInformation = userInformation;
    }

    public String Registration() {
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
    public String LogInPage(){return"logInPage.xhtml?faces-redirect=true";}

    public void PositiveAnswer() {
        if(newPassword1.equals(newPassword2)) {
            saveUser();
            addMessage("Готово", "Данные сохранены");
        } else {
            addMessage("nepravilny parol", "");
        }
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
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

        siteUser.setDateOfEvent(this.dateOfEvent);
        siteUser.setRecommendations(this.recommendations);
        userRepository.save(siteUser);
    }

    private void createAdminUserIfNotExists() {
        //--- создаем при старте админского пользователя в базе если его не существует
        if (userRepository.findByPhone("(999) 999-99-99").isEmpty()) {
            SiteUser admin = new SiteUser();
            admin.setPhone("(999) 999-99-99");
            admin.setPassword("vasya");
            admin.setRole(SecurityRole.ROLE_ADMIN);
            admin.setName("Vasya");
            admin.setSurname("Vasya");
            admin.setCity("Kiev");
            admin.setEmail("vasya@vasya");
            admin.setGender("M");
            admin.setDateOfBirth(new Date());
            userRepository.save(admin);
        }
    }

}
