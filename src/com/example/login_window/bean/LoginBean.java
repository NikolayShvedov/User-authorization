package com.example.login_window.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
/**
 * JavaBean class used in jsp action tags.
 * @author Nikolay Shvedov
 */

@Getter
@Setter
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String login;
    private String password;

}
