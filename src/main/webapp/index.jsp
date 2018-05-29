<%@ page import="entities.PersonageEntity" %>
<%@ page import="entities.PlayerEntity" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="utils.EntityDao" %>
<%@ page import="utils.HibernateUtil" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Go to the Pathfinder</title>
</head>
<body>
<%
    try (Session sess = new HibernateUtil().getSession()) {
        EntityDao<PlayerEntity> dao = new EntityDao<>(sess);
        PlayerEntity user = dao.readEntity(PlayerEntity.class, (Long)session.getAttribute("userId"));
        switch (user.getName()) {
            case "player":
%>
                <h3>Personage list:</h3>
                <ul>
                <%
                    for (PersonageEntity personage : user.getPersonages()) {
                %>
                    <li><a href="pages/personageDetails.jsp?id=<%=personage.primaryKey()%>"><%=personage.getName()%></a></li>
                <%
                    }
                %>
                </ul>
                <a href="${pageContext.request.contextPath}/Personage">Create</a>
<%
                break;
            case "master":
%>
                <a href="${pageContext.request.contextPath}/pages/allPersonages.jsp">personage</a>
                <a href="${pageContext.request.contextPath}/entities?type=Race&action=show">race</a>
                <a href="${pageContext.request.contextPath}/entities?type=PersonageClass&action=show">class</a>
                <a href="${pageContext.request.contextPath}/entities?type=Spell&action=show">spell</a>
                <a href="${pageContext.request.contextPath}/entities?type=Weapon&action=show">weapon</a>
<%
                break;
        }
    }
%>
<!--
<a href="${pageContext.request.contextPath}/entities?type=Player&action=show">player</a>
<a href="${pageContext.request.contextPath}/entities?type=Race&action=show">race</a>
<a href="${pageContext.request.contextPath}/entities?type=PersonageClass&action=show">class</a>
<a href="${pageContext.request.contextPath}/entities?type=Spell&action=show">spell</a>
<a href="${pageContext.request.contextPath}/entities?type=Weapon&action=show">weapon</a>
<a href="${pageContext.request.contextPath}/entities?type=Personage&action=show">personage</a>
-->
</body>
</html>
