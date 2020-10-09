<%--
  Created by IntelliJ IDEA.
  User: Nikolay Shvedov
  Date: 03.10.2020
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
    <title>JSP Page</title>
</head>
<body>
<%
    String URL = "jdbc:mysql://localhost:3306/login_window"+
            "?verifyServerCertificate=false"+
            "&useSSL=false"+
            "&requireSSL=false"+
            "&useLegacyDatetimeCode=false"+
            "&amp"+
            "&serverTimezone=UTC";
    String USERNAME = "root";
    String PASSWORD = "root";
    Connection connection = null;
    String login_user = null;
    String password_user = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    } catch (Exception e){
        System.err.println(e);
    }
    ResultSet users_list = null;
    try {
        login_user = request.getParameter("login");
        password_user = request.getParameter("password");
        Statement s = connection.createStatement();
        users_list = s.executeQuery("SELECT * FROM users;");
        boolean check=false;
        while (users_list.next()) {

            if ((login_user.equals(users_list.getString("login")))&(password_user.equals(users_list.getString("password")))) {
                String user_name = "Здравствуйте, " + users_list.getString("last_name") + " " + users_list.getString("first_name");
%> <%=user_name %> <%
            check = true;
        }
    }
    if (!check) { %> Ошибка ввода логина или пароля
<br> <a href="http://localhost:8080/login_window_fix_war_exploded/index.jsp">Назад</a>
<% }
} catch (Exception e) {
    System.out.println(e);}
%>
</body>
</html>
