package com.example.lolhanding.entity;

import java.io.Serializable;

public class ProductInfo implements Serializable {
    private int product_id;
    private int product_img;
    private String product_title;
    private int produt_price;

    public ProductInfo(int product_id, int product_img, String product_title, int produt_price) {
        this.product_id = product_id;
        this.product_img = product_img;
        this.product_title = product_title;
        this.produt_price = produt_price;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_img() {
        return product_img;
    }

    public void setProduct_img(int product_img) {
        this.product_img = product_img;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public int getProdut_price() {
        return produt_price;
    }

    public void setProdut_price(int produt_price) {
        this.produt_price = produt_price;
    }


}
