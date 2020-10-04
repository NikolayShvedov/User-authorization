package com.example.login_window.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * JavaBean class used in jsp action tags.
 * @author Nikolay Shvedov
 */

@Getter
@Setter
public class RegistrationBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String login;
    private String password;

}
