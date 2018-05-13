<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Go to the Moon</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/entities?type=Player&action=show">player</a>
<a href="${pageContext.request.contextPath}/entities?type=Race&action=show">race</a>
<a href="${pageContext.request.contextPath}/entities?type=PersonageClass&action=show">class</a>
<a href="${pageContext.request.contextPath}/entities?type=Spell&action=show">spell</a>
<a href="${pageContext.request.contextPath}/entities?type=Weapon&action=show">weapon</a>
<a href="${pageContext.request.contextPath}/entities?type=Personage&action=show">personage</a>
</body>
</html>
