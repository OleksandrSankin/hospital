package com.example.demo.controlles;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@ManagedBean
public class ImagesView {

        private List<String> images;

        @PostConstruct
        public void init() {
            images = new ArrayList<String>();
            for (int i = 1; i <= 6; i++) {
                images.add("hospital" + i + ".jpg");
            }
        }

        public List<String> getImages() {
            return images;
        }
    }


