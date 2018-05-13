<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spell</title>
</head>
<body>
<%
    PersonageEntity entity = (PersonageEntity) session.getAttribute("entity");
    List<PersonageClassEntity> personageClasses = (List<PersonageClassEntity>) session.getAttribute("classes");
    List<RaceEntity> races = (List<RaceEntity>) session.getAttribute("races");
    List<PlayerEntity> players = (List<PlayerEntity>) session.getAttribute("players");
    List<WeaponEntity> weapons = (List<WeaponEntity>) session.getAttribute("weapons");
    session.removeAttribute("entity");
    session.removeAttribute("classes");
    session.removeAttribute("races");
    session.removeAttribute("players");
    session.removeAttribute("weapons");
%>
<form action="${pageContext.request.contextPath}/Personage" method="post">
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
        <label for="xp">xp</label>
        <input id="xp" name="xp" type="number" min="0"
                <%=(entity == null)?"":"value=" + entity.getXp()%>/>
    </div>
    <div>
        <label>alignment</label>
        <select id="alignment" name="alignment">
            <option value="LG"
                    <%=(entity != null && entity.getAlignment().equals("LG"))?"selected":""%>>
                lawful good
            </option>
            <option value="NG"
                    <%=(entity != null && entity.getAlignment().equals("NG"))?"selected":""%>>
                neutral good
            </option>
            <option value="CG"
                    <%=(entity != null && entity.getAlignment().equals("CG"))?"selected":""%>>
                chaotic good
            </option>
            <option value="LN"
                    <%=(entity != null && entity.getAlignment().equals("LN"))?"selected":""%>>
                lawful neutral
            </option>
            <option value="NN"
                    <%=(entity != null && entity.getAlignment().equals("NN"))?"selected":""%>>
                neutral
            </option>
            <option value="CN"
                    <%=(entity != null && entity.getAlignment().equals("CN"))?"selected":""%>>
                chaotic neutral
            </option>
            <option value="LE"
                    <%=(entity != null && entity.getAlignment().equals("LE"))?"selected":""%>>
                lawful evil
            </option>
            <option value="NE"
                    <%=(entity != null && entity.getAlignment().equals("NE"))?"selected":""%>>
                neutral evil
            </option>
            <option value="CE"
                    <%=(entity != null && entity.getAlignment().equals("CE"))?"selected":""%>>
                chaotic evil
            </option>
        </select>
    </div>
    <div>
        <label for="characteristics">characteristics</label>
        <textarea id="characteristics" name="characteristics"><%=(entity == null) ? "" : entity.getCharacteristics()%></textarea>
    </div>
    <div>
        <label for="class">class</label>
        <select id="class" name="class">
            <%
                for (PersonageClassEntity personageClass : personageClasses) {
            %>
            <option value="<%=personageClass.getId()%>"
                    <%=(entity != null && entity.getPersonageClass().getId() == personageClass.getId())?"selected":""%>>
                <%=personageClass.getName()%>
            </option>
            <%
                }
            %>
        </select>
    </div>
    <div>
        <label for="race">race</label>
        <select id="race" name="race">
            <%
                for (RaceEntity race : races) {
            %>
            <option value="<%=race.getId()%>"
                    <%=(entity != null && entity.getRace().getId() == race.getId())?"selected":""%>>
                <%=race.getName()%>
            </option>
            <%
                }
            %>
        </select>
    </div>
    <div>
        <label for="weapon1">weapon #1</label>
        <select id="weapon1" name="weapon1">
            <%
                for (WeaponEntity weapon : weapons) {
            %>
            <option value="<%=weapon.getId()%>">
                <%=weapon.getName()%>
            </option>
            <%
                }
            %>
        </select>
    </div>
    <div>
        <label for="weapon2">weapon #2</label>
        <select id="weapon2" name="weapon2">
            <%
                for (WeaponEntity weapon : weapons) {
            %>
            <option value="<%=weapon.getId()%>">
                <%=weapon.getName()%>
            </option>
            <%
                }
            %>
        </select>
    </div>
    <div>
        <label for="weapon3">weapon #3</label>
        <select id="weapon3" name="weapon3">
            <%
                for (WeaponEntity weapon : weapons) {
            %>
            <option value="<%=weapon.getId()%>">
                <%=weapon.getName()%>
            </option>
            <%
                }
            %>
        </select>
    </div>
    <div>
        <label for="player">player</label>
        <select id="player" name="player">
            <%
                for (PlayerEntity player : players) {
            %>
            <option value="<%=player.getId()%>"
                    <%=(entity != null && entity.getOwner().getId() == player.getId())?"selected":""%>>
                <%=player.getName()%>
            </option>
            <%
                }
            %>
        </select>
    </div>
    <button type="submit">OK</button>
</form>
</body>
</html>
