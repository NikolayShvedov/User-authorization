package com.example.login_window.servlets;

import com.example.login_window.bean.LoginBean;
import com.example.login_window.database.LoginWindowDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private LoginWindowDao loginWindowDao;

    public void init() {
        loginWindowDao = new LoginWindowDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setLogin(login);
        loginBean.setPassword(password);
        try {
            if (loginWindowDao.authorization(loginBean)) {
                response.sendRedirect("home?login="+ login);
            } else {
                request.setAttribute("error", "Unknown user, please try again");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException | IOException | ServletException e) {
            e.printStackTrace();
        }
    }

}
