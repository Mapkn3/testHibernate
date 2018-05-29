<%@ page import="entities.PersonageEntity" %>
<%@ page import="utils.HibernateUtil" %>
<%@ page import="utils.EntityDao" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="entities.PlayerEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Personages</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/index.jsp">Homepage</a>
<%
    try (Session sess = new HibernateUtil().getSession()) {
        EntityDao<PersonageEntity> dao = new EntityDao<>(sess);
%>
        <ul>
<%
        for (PersonageEntity personage : dao.getAll(PersonageEntity.class)) {
%>
            <li>
                <form action="${pageContext.request.contextPath}/Personage" method="get">
                    <b><%=personage.getOwner().getName()%></b><br/>
                    <%=personage.getName()%>(<%=personage.getLevel()%>)<br/>
                    <%=personage.getRace()%>/<%=personage.getPersonageClass()%><br/>
                    <%=personage.getXp()%>
                    <input id="id" name="id" type="number" value="<%=personage.primaryKey()%>" hidden readonly>
                    <input id="xp" name="xp" type="number">
                    <button type="submit">Add XP</button>
                </form>
            </li>
<%
        }
%>      </ul>
<%
    }
%>
</body>
</html>
