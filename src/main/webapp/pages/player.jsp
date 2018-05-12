<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entities.PlayerEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Player</title>
</head>
<body>
<%
    PlayerEntity entity = (PlayerEntity) session.getAttribute("entity");
    session.removeAttribute("entity");
%>
<form action="${pageContext.request.contextPath}/Player" method="post">
    <div>
        <label for="id">id</label>
        <input id="id" name="id" type="number" min="0"
               required <%=(entity == null) ? "" : "value=" + entity.getId() + " readonly"%>/>
    </div>
    <div>
        <label for="name">name</label>
        <input id="name" name="name" type="text" value="<%=(entity == null)?"":entity.getName()%>"/>
    </div>
    <button type="submit">OK</button>
</form>
</body>
</html>
