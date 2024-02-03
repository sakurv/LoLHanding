package com.example.lolhanding.entity;

import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;

public class HomeInfo implements Serializable {

    private int home_img;
    private String home_title;
    private String home_des;
    private String home_url;

    public HomeInfo(int home_img, String home_title, String home_des, String home_url) {
        this.home_img = home_img;
        this.home_title = home_title;
        this.home_des = home_des;
        this.home_url = home_url;
    }

    public int getHome_img() {
        return home_img;
    }

    public void setHome_img(int home_img) {
        this.home_img = home_img;
    }

    public String getHome_title() {
        return home_title;
    }

    public void setHome_title(String home_title) {
        this.home_title = home_title;
    }

    public String getHome_des() {
        return home_des;
    }

    public void setHome_des(String home_des) {
        this.home_des = home_des;
    }

    public String getHome_url() {
        return home_url;
    }

    public void setHome_url(String home_url) {
        this.home_url = home_url;
    }
}
