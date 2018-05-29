<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entities.*" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Personage</title>
</head>
<body>
<%
    PersonageEntity entity = (PersonageEntity) session.getAttribute("entity");
    List<PersonageClassEntity> personageClasses = (List<PersonageClassEntity>) session.getAttribute("classes");
    List<RaceEntity> races = (List<RaceEntity>) session.getAttribute("races");
    List<WeaponEntity> weapons = (List<WeaponEntity>) session.getAttribute("weapons");
    session.removeAttribute("entity");
    session.removeAttribute("classes");
    session.removeAttribute("races");
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
        <label for="class">class</label>
        <select id="class" name="class">
            <%
                for (PersonageClassEntity personageClass : personageClasses) {
            %>
            <option value="<%=personageClass.getId()%>"
                    <%=(entity != null && entity.getPersonageClass().getId() == personageClass.getId()) ? "selected" : ""%>>
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
                    <%=(entity != null && entity.getRace().getId() == race.getId()) ? "selected" : ""%>>
                <%=race.getName()%>
            </option>
            <%
                }
            %>
        </select>
    </div>
    <div>
        <label for="xp">xp</label>
        <input id="xp" name="xp" type="number" min="0"
                value="<%=(entity == null) ? "" : entity.getXp()%>"/>
    </div>
    <div>
        <label for="alignment">alignment</label>
        <select id="alignment" name="alignment">
            <option value="LG"
                    <%=(entity != null && entity.getAlignment().equals("LG")) ? "selected" : ""%>>
                lawful good
            </option>
            <option value="NG"
                    <%=(entity != null && entity.getAlignment().equals("NG")) ? "selected" : ""%>>
                neutral good
            </option>
            <option value="CG"
                    <%=(entity != null && entity.getAlignment().equals("CG")) ? "selected" : ""%>>
                chaotic good
            </option>
            <option value="LN"
                    <%=(entity != null && entity.getAlignment().equals("LN")) ? "selected" : ""%>>
                lawful neutral
            </option>
            <option value="NN"
                    <%=(entity != null && entity.getAlignment().equals("NN")) ? "selected" : ""%>>
                neutral
            </option>
            <option value="CN"
                    <%=(entity != null && entity.getAlignment().equals("CN")) ? "selected" : ""%>>
                chaotic neutral
            </option>
            <option value="LE"
                    <%=(entity != null && entity.getAlignment().equals("LE")) ? "selected" : ""%>>
                lawful evil
            </option>
            <option value="NE"
                    <%=(entity != null && entity.getAlignment().equals("NE")) ? "selected" : ""%>>
                neutral evil
            </option>
            <option value="CE"
                    <%=(entity != null && entity.getAlignment().equals("CE")) ? "selected" : ""%>>
                chaotic evil
            </option>
        </select>
    </div>
    <div>
        <label for="hp">hp</label>
        <input id="hp" name="hp" type="number" min="0"
               value="<%=(entity == null) ? "" : entity.getHp()%>"/>
    </div>
    <div>
        <label for="age">age</label>
        <input id="age" name="age" type="number" min="1"
               value="<%=(entity == null) ? "" : entity.getAge()%>"/>
    </div>
    <div>
        <label for="valStrenght">valStrenght</label>
        <input id="valStrenght" name="valStrenght" type="number" min="3" max="20"
               value="<%=(entity == null) ? "" : entity.getValStrenght()%>"/>
        <button onclick="document.getElementById('valStrenght').value = randomInteger(3, 20)" type="button">generate</button>
    </div>
    <div>
        <label for="valDexterity">valDexterity</label>
        <input id="valDexterity" name="valDexterity" type="number" min="3" max="20"
               value="<%=(entity == null) ? "" : entity.getValDexterity()%>"/>
        <button onclick="document.getElementById('valDexterity').value = randomInteger(3, 20)" type="button">generate</button>
    </div>
    <div>
        <label for="valConstitution">valConstitution</label>
        <input id="valConstitution" name="valConstitution" type="number" min="3" max="20"
               value="<%=(entity == null) ? "" : entity.getValConstitution()%>"/>
        <button onclick="document.getElementById('valConstitution').value = randomInteger(3, 20)" type="button">generate</button>
    </div>
    <div>
        <label for="valIntelligence">valIntelligence</label>
        <input id="valIntelligence" name="valIntelligence" type="number" min="3" max="20"
               value="<%=(entity == null) ? "" : entity.getValIntelligence()%>"/>
        <button onclick="document.getElementById('valIntelligence').value = randomInteger(3, 20)" type="button">generate</button>
    </div>
    <div>
        <label for="valWisdom">valWisdom</label>
        <input id="valWisdom" name="valWisdom" type="number" min="3" max="20"
               value="<%=(entity == null) ? "" : entity.getValWisdom()%>"/>
        <button onclick="document.getElementById('valWisdom').value = randomInteger(3, 20)" type="button">generate</button>
    </div>
    <div>
        <label for="valCharisma">valCharisma</label>
        <input id="valCharisma" name="valCharisma" type="number" min="3" max="20"
               value="<%=(entity == null) ? "" : entity.getValCharisma()%>"/>
        <button onclick="document.getElementById('valCharisma').value = randomInteger(3, 20)" type="button">generate</button>
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
    <button type="submit">OK</button>
</form>
<script>
    function randomInteger(min, max) {
        var rand = min + Math.random() * (max + 1 - min);
        rand = Math.floor(rand);
        return rand;
    }
</script>
</body>
</html>
