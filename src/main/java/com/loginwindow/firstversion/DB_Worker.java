package com.loginwindow.firstversion;

import java.sql.*;
import javax.swing.JOptionPane;

/*
 * Класс для работы с базой данных в MySQL
 * @author Николай Шведов
 */
public class DB_Worker
{
    private static final String URL = "jdbc:mysql://localhost:3306/my_test_database?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private Connection connection;
    /*
     * Функция для подключения к базе данных
     */
    public void Connections()
    {
        Driver driver;
        try
        {
            connection = DriverManager.getConnection(URL, USERNAME,PASSWORD);
        }
        catch (SQLException e1)
        {
            String err = "Error!!!";
            System.out.println(err);
        }
    }
    /*
     * Функция для заполнения таблицы в MySQL, хранящей данные о пользователе
     */
    void Populating_database(String firstname, String lastname, String username, String password, String address)
    {
        try {
            String query = " insert into logins (firstname, lastname, username, password, address)"  + " values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, firstname);
            preparedStmt.setString (2, lastname);
            preparedStmt.setString (3, username);
            preparedStmt.setString (4, password);
            preparedStmt.setString (5, address);
            preparedStmt.execute();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
    /*
     * Функция для перебора значений из базы данных для подтверждения правильгности ввода логина и пароля пользователем
     */
    void Brute_force_data(String login, String password)
    {
        Driver driver;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME,PASSWORD))
        {
            String query = "select * from logins";
            String firstname = null, lastname = null, username, pass, address = null;
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            boolean temp = false;
            while ((result.next()))
            {
                username = result.getString(4);
                pass = result.getString(5);
                if ((username.equals(login))&&(pass.equals(password)))
                {
                    temp = true;
                    firstname = result.getString(2);
                    lastname = result.getString(3);
                    address = result.getString(6);
                }
            }
            if (temp == false)
            {
                JOptionPane.showMessageDialog(null, "Error! You have entered the wrong username or password!", "Login form", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                String  message = "";
                message += "Congratulations, you have opened the application!\n";
                message += "Your first name is: " + firstname + "\n";
                message += "Your last name is: " + lastname + "\n";
                message += "Your address is: " + address;
                JOptionPane.showMessageDialog(null, message, "Login form", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
        } ;
    }
}