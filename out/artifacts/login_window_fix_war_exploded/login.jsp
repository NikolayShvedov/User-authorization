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
    <title>Authorization User</title>
</head>
<body>
<form action="login" method="post">
    <h1>Окно авторизации пользователей</h1>
    <p><input type="text" name="login" value="" placeholder="Login"></p>
    <p><input type="password" name="password" value="" placeholder="Password"></p>
    </p>
    <p><input type="submit" value="Войти"></p>
    <span class="error">${error}</span>
</form>
<div id="res"></div>
</body>
</html>
