<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entities.PersonageClassEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.SpellEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spell</title>
</head>
<body>
<%
    SpellEntity entity = (SpellEntity) session.getAttribute("entity");
    List<PersonageClassEntity> personageClasses = (List<PersonageClassEntity>) session.getAttribute("classes");
    session.removeAttribute("entity");
    session.removeAttribute("classes");
%>
<form action="${pageContext.request.contextPath}/Spell" method="post">
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
        <label for="description">description</label>
        <textarea id="description" name="description"><%=(entity == null) ? "" : entity.getDescription()%></textarea>
    </div>
    <div>
        <label for="class">class</label>
        <select id="class" name="class">
            <%
                for (PersonageClassEntity personageClass : personageClasses) {
            %>
                    <option value="<%=personageClass.getId()%>"><%=personageClass.getName()%></option>
            <%
                }
            %>
        </select>
    </div>
    <button type="submit">OK</button>
</form>
</body>
</html>
