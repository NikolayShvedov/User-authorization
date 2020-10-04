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
    <title>Authorization User</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
    <h1>Окно регистрации пользователей</h1>
    <form action="registration" method="post">

        <div class="form-group">
            <%--@declare id="uname"--%>
            <label for="uname">Фамилия:</label> <input type="text"
                                                       class="form-control" id="first_name" placeholder="First Name User"
                                                       name="first_name" required>
        </div>

        <div class="form-group">
            <label for="uname">Имя:</label> <input type="text"
                                                   class="form-control" id="last_name" placeholder="Last Name User"
                                                   name="last_name" required>
        </div>

        <div class="form-group">
            <label for="uname">Логин:</label> <input type="password"
                                                     class="form-control" id="login" placeholder="Login"
                                                     name="login" required>
        </div>

        <div class="form-group">
            <label for="uname">Пароль:</label> <input type="password"
                                                      class="form-control" id="password" placeholder="Password"
                                                      name="password" required>
        </div>

        <button type="submit" class="btn btn-primary">Зарегистрировать меня</button>

    </form>
</div>
</body>
</html>
