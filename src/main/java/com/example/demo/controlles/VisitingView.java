package com.example.demo.controlles;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

@ManagedBean
@ApplicationScoped
public class VisitingView {

    private final static String[] dates;


    static {
        dates = new String[10];
        dates[0] = "10";
        dates[1] = "10";
        dates[2] = "10";
        dates[3] = "10";

    }
}
