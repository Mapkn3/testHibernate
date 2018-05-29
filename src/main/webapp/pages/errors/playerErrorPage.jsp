<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Player Error Page</title>
</head>
<body>
<h1>
    <%=request.getParameter("errorMessage")%>
</h1>
<a href="#" onclick="history.back()">Назад</a>
</body>
</html>
