package com.sumsign.caterwin.domain.entity.request;

/**
 * Created by Long Nguyen on 18/7/2017.
 */

public class UserLoginModel {
    private String email;
    private String password;

    public UserLoginModel() {
    }

    public UserLoginModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


