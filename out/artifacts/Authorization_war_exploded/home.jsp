<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
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
    Connection connection = null;
    String inputString1 = null;
    String inputString2 = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/users_db"+
                "?verifyServerCertificate=false"+
                "&useSSL=false"+
                "&requireSSL=false"+
                "&useLegacyDatetimeCode=false"+
                "&amp"+
                "&serverTimezone=UTC";
        connection = DriverManager.getConnection(url, "root", "root");
    } catch (Exception e)
    {
        System.err.println(e);
    }
    ResultSet r = null;
    try {
        inputString1 = request.getParameter("login");
        inputString2 = request.getParameter("password");
        Statement s = connection.createStatement();
        PreparedStatement pr = connection.prepareStatement("insert into besuchsprotokoll(id_user,times,ip) values(?,?,?);");
        r = s.executeQuery("SELECT * FROM users;");
        boolean check=false;
        while (r.next()) {

            if ((inputString1.equals(r.getString("logins")))&(inputString2.equals(r.getString("passwords")))) {
                String str = "Здравствуйте, " + r.getString("fio");
                int id = r.getInt(1);
%> <%=str %> <%
            check = true;
            InetAddress addr = InetAddress.getLocalHost();
            String ip = addr.getHostAddress();
            Calendar calendar = Calendar.getInstance();
            Date time = calendar.getTime();
            String ti = time.toString();
            pr.setInt(1,id);
            pr.setString(2, ti);
            pr.setString(3, ip);
            pr.executeUpdate();
        }
    }
    if (!check) { %> Ошибка ввода логина или пароля
<br> <a href="http://localhost:8080/JavaLoginJSP/index.jsp">Назад</a>
<% }
} catch (Exception e) {
    System.out.println(e);}
%>
</body>
</html>
