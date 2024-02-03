package com.example.lolhanding.entity;

public class LegendInfo {
    String account;
    int img;

    public LegendInfo(String account, int img) {
        this.account = account;
        this.img = img;
    }
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }



    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
