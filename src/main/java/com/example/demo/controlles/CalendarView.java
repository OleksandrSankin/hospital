package com.example.demo.controlles;


import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean
    public class CalendarView {

        private Data date;
        private List<Date> invalidDates;


        @PostConstruct
        public void init() {
            invalidDates = new ArrayList<>();
            Date today = new Date();
            invalidDates.add(today);
            long oneDay = 24 * 60 * 60 * 1000;
            for (int i = 0; i < 5; i++) {
                invalidDates.add(new Date(invalidDates.get(i).getTime() + oneDay));
            }


        }

        public void click() {
            PrimeFaces.current().ajax().update("form:display");
            PrimeFaces.current().executeScript("PF('dlg').show()");
        }


    public Data getDate() {
        return date;
    }

    public void setDate(Data date) {
        this.date = date;
    }



    }

