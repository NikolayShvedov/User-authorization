package com.example.login_window.servlets;

import com.example.login_window.bean.RegistrationBean;
import com.example.login_window.database.LoginWindowDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private LoginWindowDao loginWindowDao;

    public void init() {
        loginWindowDao = new LoginWindowDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("registration.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        RegistrationBean registrationBean = new RegistrationBean();

        registrationBean.setFirstName(firstName);
        registrationBean.setLastName(lastName);
        registrationBean.setLogin(login);
        registrationBean.setPassword(password);

        try {

            loginWindowDao.registration(registrationBean);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("index.jsp");
    }

}
