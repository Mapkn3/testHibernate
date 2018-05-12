<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entities.RaceEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Race</title>
</head>
<body>
<%
    RaceEntity entity = (RaceEntity) session.getAttribute("entity");
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
        <label for="size">size</label>
        <select id="size" name="size">
            <option value="S" <%=(entity != null && entity.getSize().equals("S"))?"selected":""%>>Small (S)</option>
            <option value="M" <%=(entity != null && entity.getSize().equals("M"))?"selected":""%>>Medium (M)</option>
            <option value="L" <%=(entity != null && entity.getSize().equals("L"))?"selected":""%>>Large (L)</option>
        </select>
    </div>
    <div>
        <label for="speed">speed</label>
        <input id="speed" name="speed" type="number" min="0" max="100" <%=(entity == null)?"":"value="+entity.getId()%>>
    </div>
    <div>
        <label for="features">features</label>
        <textarea id="features" name="features"><%=(entity == null) ? "" : entity.getFeatures()%></textarea>
    </div>
    <button type="submit">OK</button>
</form>
</body>
</html>
