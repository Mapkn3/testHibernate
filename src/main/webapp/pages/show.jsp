<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.lang.reflect.Field" %>
<%@ page import="entities.PrettyEntity" %>
<html>
<head>
    <title>Entities</title>
</head>
<body>
<%
    String type = request.getParameter("type");
    List entities = (List)session.getAttribute("entities");
    Class metadata = (Class)session.getAttribute("metadata");
    String className = metadata.getSimpleName();
%>
<h1><%=className%></h1>
<a href="${pageContext.request.contextPath}/index.jsp">Homepage</a>
<table border="1" cellspacing="0">
    <tr><%
    for (Field field : metadata.getDeclaredFields()) {
        String fieldName = field.getName();
    %>
    <td><%=fieldName%></td>
    <%
    }
    %><td colspan="2">Action</td>
    </tr><%
    for (Object entity : entities) {
%><tr><%
        Class entityClass = entity.getClass();
        for (Field entityField : entityClass.getDeclaredFields()) {
            entityField.setAccessible(true);
            Object fieldValue = entityField.get(entity);
%>
    <td><%=fieldValue%></td>
<%
        }
%>
    <td>
        <a href="${pageContext.request.contextPath}/entities?action=delete&type=<%=type%>&id=<%=((PrettyEntity)entity).primaryKey()%>">Delete</a>
    </td>
    <td>
        <a href="${pageContext.request.contextPath}/entities?action=edit&type=<%=type%>&id=<%=((PrettyEntity)entity).primaryKey()%>">Edit</a>
    </td>
</tr>
<%
    }
%>
</table>
<a href="${pageContext.request.contextPath}/<%=className.substring(0, className.length()-"Entity".length())%>">Create</a>
</body>
</html>
