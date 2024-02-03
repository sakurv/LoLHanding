package com.example.lolhanding.entity;

public class CarInfo {
    private int car_id;
    private String username;
    private String product_title;
    private int product_img;


    private int product_num;
    private int product_pri;

    public CarInfo(int car_id, String username, String product_title, int product_img, int product_num, int product_pri) {
        this.car_id = car_id;
        this.username = username;
        this.product_title = product_title;
        this.product_img = product_img;
        this.product_num = product_num;
        this.product_pri = product_pri;
    }
    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getProduct_num() {
        return product_num;
    }

    public void setProduct_num(int product_num) {
        this.product_num = product_num;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public int getProduct_img() {
        return product_img;
    }

    public void setProduct_img(int product_img) {
        this.product_img = product_img;
    }

    public int getProduct_pri() {
        return product_pri;
    }

    public void setProduct_pri(int product_pri) {
        this.product_pri = product_pri;
    }
}
