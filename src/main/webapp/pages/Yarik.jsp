<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css" type="text/css" media="all">
    <title>Start</title>
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
                <a href="${pageContext.request.contextPath}/Player">Регистрация</a>
            </div>
        </form><!-- form -->
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
