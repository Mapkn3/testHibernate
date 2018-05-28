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
    <div>
        <label for="maxHp">maxHp</label>
        <select id="maxHp" name="maxHp">
            <option value="3"
                    <%=(entity != null && entity.getMaxHp() == 3)?"selected":""%>>
                d3
            </option>
            <option value="4"
                    <%=(entity != null && entity.getMaxHp() == 4)?"selected":""%>>
                d4
            </option>
            <option value="6"
                    <%=(entity != null && entity.getMaxHp() == 6)?"selected":""%>>
                d6
            </option>
            <option value="8"
                    <%=(entity != null && entity.getMaxHp() == 8)?"selected":""%>>
                d8
            </option>
            <option value="10"
                    <%=(entity != null && entity.getMaxHp() == 10)?"selected":""%>>
                d10
            </option>
            <option value="12"
                    <%=(entity != null && entity.getMaxHp() == 12)?"selected":""%>>
                d12
            </option>
            <option value="20"
                    <%=(entity != null && entity.getMaxHp() == 20)?"selected":""%>>
                d20
            </option>
        </select>
    </div>
    <div>
        <label for="researchAcrobatics">researchAcrobatics</label>
        <select id="researchAcrobatics" name="researchAcrobatics">
            <option value="y"
                    <%=(entity != null && entity.getResearchAcrobatics().equals("y"))?"selected":""%>>
                yes
            </option>
            <option value="n"
                    <%=(entity != null && entity.getResearchAcrobatics().equals("n"))?"selected":""%>>
                no
            </option>
        </select>
    </div>
    <div>
        <label for="researchBluff">researchBluff</label>
        <select id="researchBluff" name="researchBluff">
            <option value="y"
                    <%=(entity != null && entity.getResearchBluff().equals("y"))?"selected":""%>>
                yes
            </option>
            <option value="n"
                    <%=(entity != null && entity.getResearchBluff().equals("n"))?"selected":""%>>
                no
            </option>
        </select>
    </div>
    <div>
        <label for="researchPerception">researchPerception</label>
        <select id="researchPerception" name="researchPerception">
            <option value="y"
                    <%=(entity != null && entity.getResearchPerception().equals("y"))?"selected":""%>>
                yes
            </option>
            <option value="n"
                    <%=(entity != null && entity.getResearchPerception().equals("n"))?"selected":""%>>
                no
            </option>
        </select>
    </div>
    <div>
        <label for="researchDiplomacy">researchDiplomacy</label>
        <select id="researchDiplomacy" name="researchDiplomacy">
            <option value="y"
                    <%=(entity != null && entity.getResearchDiplomacy().equals("y"))?"selected":""%>>
                yes
            </option>
            <option value="n"
                    <%=(entity != null && entity.getResearchDiplomacy().equals("n"))?"selected":""%>>
                no
            </option>
        </select>
    </div>
    <div>
        <label for="researchSpellcraft">researchSpellcraft</label>
        <select id="researchSpellcraft" name="researchSpellcraft">
            <option value="y"
                    <%=(entity != null && entity.getResearchSpellcraft().equals("y"))?"selected":""%>>
                yes
            </option>
            <option value="n"
                    <%=(entity != null && entity.getResearchSpellcraft().equals("n"))?"selected":""%>>
                no
            </option>
        </select>
    </div>
    <div>
        <label>baseAttackBonus</label>
        <input id="baseAttackBonus" name="baseAttackBonus" type="number" min="-2" max="20"
            <%=(entity == null) ? "" : "value=" + entity.getBaseAttackBonus()%>>
    </div>
    <button type="submit">OK</button>
</form>
</body>
</html>
