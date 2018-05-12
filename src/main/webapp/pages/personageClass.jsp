<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entities.PersonageClassEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Personage Class</title>
</head>
<body>
<%
    PersonageClassEntity entity = (PersonageClassEntity) session.getAttribute("entity");
    session.removeAttribute("entity");
%>
<form action="${pageContext.request.contextPath}/PersonageClass" method="post">
    <div>
        <label for="id">id</label>
        <input id="id" name="id" type="number" min="0"
               required <%=(entity == null) ? "" : "value=" + entity.getId() + " readonly"%>/>
    </div>
    <div>
        <label for="name">name</label>
        <input id="name" name="name" type="text" value="<%=(entity == null)?"":entity.getName()%>"/>
    </div>
    <div>
        <label for="features">features</label>
        <textarea id="features" name="features"><%=(entity == null) ? "" : entity.getFeatures()%></textarea>
    </div>
    <button type="submit">OK</button>
</form>
</body>
</html>
