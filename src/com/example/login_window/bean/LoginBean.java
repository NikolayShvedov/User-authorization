package com.example.login_window.bean;

import java.io.Serializable;

/**
 * JavaBean class used in jsp action tags.
 * @author Nikolay Shvedov
 */

public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
