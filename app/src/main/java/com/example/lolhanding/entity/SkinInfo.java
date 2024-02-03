package com.example.lolhanding.entity;

public class SkinInfo {
    int skin_id;
    String skin_account;
    String name;
    int skin_img;

    public SkinInfo(int skin_id, String skin_account, String name, int skin_img) {
        this.skin_id = skin_id;
        this.skin_account = skin_account;
        this.name = name;
        this.skin_img = skin_img;
    }

    public int getSkin_id() {
        return skin_id;
    }

    public void setSkin_id(int skin_id) {
        this.skin_id = skin_id;
    }

    public String getSkin_account() {
        return skin_account;
    }

    public void setSkin_account(String skin_account) {
        this.skin_account = skin_account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkin_img() {
        return skin_img;
    }

    public void setSkin_img(int skin_img) {
        this.skin_img = skin_img;
    }
}
