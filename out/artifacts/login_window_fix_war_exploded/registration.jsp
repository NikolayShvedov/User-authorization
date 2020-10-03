<%--
  Created by IntelliJ IDEA.
  User: Nikolay Shvedov
  Date: 03.10.2020
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<div align="center">
    <form action="registration" method="post">
    <h1>Окно регистрации пользователей</h1>
        <table style="with: 80%">
            <tr>
                <td>Фамилия</td>
                <td><input type="text" name="first_name" /></td>
            </tr>
            <tr>
                <td>Имя</td>
                <td><input type="text" name="last_name" /></td>
            </tr>
            <tr>
                <td>Логин</td>
                <td><input type="text" name="login" /></td>
            </tr>
            <tr>
                <td>Пароль</td>
                <td><input type="password" name="password" /></td>
            </tr>
        </table>
        <input type="submit" value="Зарегистрировать меня" />
    </form>
</div>
</body>
</html>
