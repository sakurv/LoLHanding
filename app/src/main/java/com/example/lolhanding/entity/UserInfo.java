package com.example.lolhanding.entity;

public class UserInfo {
    int user_id;
    String user_account;
    String user_password;
    String user_name;
    int user_head;
    Double user_ticket;
    Double user_blue;

    public UserInfo(int user_id, String user_account, String user_password, String user_name, int user_head, Double user_ticket, Double user_blue) {
        this.user_id = user_id;
        this.user_account = user_account;
        this.user_password = user_password;
        this.user_name = user_name;
        this.user_head = user_head;
        this.user_ticket = user_ticket;
        this.user_blue = user_blue;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_head() {
        return user_head;
    }

    public void setUser_head(int user_head) {
        this.user_head = user_head;
    }

    public Double getUser_ticket() {
        return user_ticket;
    }

    public void setUser_ticket(Double user_ticket) {
        this.user_ticket = user_ticket;
    }

    public Double getUser_blue() {
        return user_blue;
    }

    public void setUser_blue(Double user_blue) {
        this.user_blue = user_blue;
    }
}
