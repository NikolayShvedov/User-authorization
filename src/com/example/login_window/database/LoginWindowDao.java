package com.example.login_window.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.login_window.bean.LoginBean;
import com.example.login_window.bean.RegistrationBean;

public class LoginWindowDao {

    private String URL = "jdbc:mysql://localhost:3306/login_window"+
            "?verifyServerCertificate=false"+
            "&useSSL=false"+
            "&requireSSL=false"+
            "&useLegacyDatetimeCode=false"+
            "&amp"+
            "&serverTimezone=UTC";
    private String USERNAME = "root";
    private String PASSWORD = "root";

    public boolean authorization(LoginBean loginBean) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE login = ? AND password = ? ")) {
            preparedStatement.setString(1, loginBean.getLogin());
            preparedStatement.setString(2, loginBean.getPassword());
            System.out.println(preparedStatement);
            ResultSet result = preparedStatement.executeQuery();
            status = result.next();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return status;
    }

    public int registration(RegistrationBean registration) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO users (first_name, last_name, login, password) VALUES (?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(first_name, last_name, login, password) values(?, ?, ?, ?);")) {

            preparedStatement.setString(1, registration.getFirstName());
            preparedStatement.setString(2, registration.getLastName());
            preparedStatement.setString(3, registration.getLogin());
            preparedStatement.setString(4, registration.getPassword());

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
