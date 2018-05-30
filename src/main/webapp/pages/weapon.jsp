<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entities.WeaponEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Personage Class</title>
</head>
<body>
<%
    WeaponEntity entity = (WeaponEntity) session.getAttribute("entity");
    session.removeAttribute("entity");
%>
<form action="${pageContext.request.contextPath}/Weapon" method="post">
    <div>
        <label for="id">id</label>
        <input id="id" name="id" type="number" min="0"
               required <%=(entity == null) ? "" : "value=" + entity.getId() + " readonly"%>/>
    </div>
    <div>
        <label for="name">name</label>
        <input id="name" name="name" type="text" value="<%=(entity == null) ? "" : entity.getName()%>"/>
    </div>
    <div>
        <label for="attackBonus">attack bonus: +</label>
        <input id="attackBonus" name="attackBonus" type="number" min="0" max="5"
        value="<%=(entity == null) ? "" : entity.getAttackBonus().toString()%>"/>
    </div>
    <div>
        <label for="criticalBonus">critical bonus: x</label>
        <input id="criticalBonus" name="criticalBonus" type="number" min="0" max="5"
        value="<%=(entity == null) ? "" : entity.getCriticalBonus().toString()%>"/>
    </div>
    <div>
        <label for="type">type</label>
        <select id="type" name="type">
            <option value="cutting"
                    <%=(entity != null && entity.getTypeOfWeapon().equals("cutting")) ? "selected" : ""%>>
                cutting
            </option>
            <option value="stabbing"
                    <%=(entity != null && entity.getTypeOfWeapon().equals("stabbing")) ? "selected" : ""%>>
                stabbing
            </option>
            <option value="crushing"
                    <%=(entity != null && entity.getTypeOfWeapon().equals("crushing")) ? "selected" : ""%>>
                crushing
            </option>
        </select>
    </div>
    <div>
        <label for="range">range</label>
        <select id="range" name="range">
            <option value="5"
                    <%=(entity != null && entity.getRangeOfWeapon() == 5) ? "selected" : ""%>>
                melee
            </option>
            <option value="20"
                    <%=(entity != null && entity.getRangeOfWeapon() == 20) ? "selected" : ""%>>
                20 ft.
            </option>
            <option value="40"
                    <%=(entity != null && entity.getRangeOfWeapon() == 40) ? "selected" : ""%>>
                40 ft.
            </option>
        </select>
    </div>
    <div>
        <label>damage</label>
        <input id="countDice" name="countDice" min="1" max="6"
                <%=(entity == null) ? "" : "value=" + entity.getDamage().substring(0, 1)%> />
        <select id="typeDice" name="typeDice">
            <option value="d3"
                    <%=(entity != null && entity.getDamage().substring(1).equals("d3")) ? "selected" : ""%>>
                d3
            </option>
            <option value="d4"
                    <%=(entity != null && entity.getDamage().substring(1).equals("d4")) ? "selected" : ""%>>
                d4
            </option>
            <option value="d6"
                    <%=(entity != null && entity.getDamage().substring(1).equals("d6")) ? "selected" : ""%>>
                d6
            </option>
            <option value="d8"
                    <%=(entity != null && entity.getDamage().substring(1).equals("d8")) ? "selected" : ""%>>
                d8
            </option>
        </select>
    </div>
    <button type="submit">OK</button>
</form>
</body>
</html>
