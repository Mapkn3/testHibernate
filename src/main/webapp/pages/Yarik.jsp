<%--
  Created by IntelliJ IDEA.
  User: Mapkn3
  Date: 23.05.2018
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Форма входа HTML5 CSS3</title>
</head>
<body>
<div class="container">
    <section id="content">
        <form action="${pageContext.request.contextPath}/Yarik" method="get">
            <h1>Вход на сайт</h1>
            <div>
                <input placeholder="Логин" id="username" name="username" type="text" required>
            </div>
            <div>
                <input placeholder="Пароль" id="password" name="password" type="password" required>
            </div>
            <div>
                <input value="Войти" type="submit">
                <a href="#">Напомнить пароль?</a>
                <a href="#">Регистрация</a>
            </div>
        </form><!-- form -->
        <div class="button"><a href="#">Скачать</a></div><!-- button -->
        <%
            String errorMessage = request.getParameter("m");
            if (errorMessage != null) {
        %>
        <div class="error">
            <%=errorMessage%>
        </div>
        <%}%>
    </section><!-- content -->
</div><!-- container -->
</body>
</html>
