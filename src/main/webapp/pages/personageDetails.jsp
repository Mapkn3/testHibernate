<%@ page import="entities.PersonageEntity" %>
<%@ page import="entities.SpellEntity" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="utils.EntityDao" %>
<%@ page import="utils.HibernateUtil" %>
<%@ page import="java.util.Collection" %>
<%@ page import="entities.WeaponEntity" %>
<%@ page import="entities.WeaponOfPersonageEntity" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Details</title>
</head>
<body>
<%
    Long personageId = Long.valueOf(request.getParameter("id"));
    try (Session sess = new HibernateUtil().getSession()) {
        EntityDao<PersonageEntity> dao = new EntityDao<>(sess);
        PersonageEntity personage = dao.readEntity(PersonageEntity.class, personageId);
        personage.calculateMod();
%>
<div>
    <a href="${pageContext.request.contextPath}/index.jsp">Homepage</a>
    <a href="${pageContext.request.contextPath}/entities?action=edit&type=Personage&id=<%=personageId%>">Edit</a>
    <h1><%=personage.getName()%></h1>
    XP: <%=personage.getXp()%><br/>
    Level: <%=personage.getLevel()%><br/>
    Alignment: <%=personage.getAlignment()%><br/>
    HP: <%=personage.getHp()%><br/>
    Age: <%=personage.getAge()%><br/>
    Acrobatics: <%=personage.getModAcrobatics()%><br/>
    Bluff: <%=personage.getModBluff()%><br/>
    Perception: <%=personage.getModPerception()%><br/>
    Diplomacy: <%=personage.getModDiplomacy()%><br/>
    Spellcraft: <%=personage.getModSpellcraft()%><br/>
    Strenght(v): <%=personage.getValStrenght()%><br/>
    Dexterity(v): <%=personage.getValDexterity()%><br/>
    Constitution(v): <%=personage.getValConstitution()%><br/>
    Intelligence(v): <%=personage.getValIntelligence()%><br/>
    Wisdom(v): <%=personage.getValWisdom()%><br/>
    Charisma(v): <%=personage.getValCharisma()%><br/>
    Fortitude: <%=personage.getModFortitude()%><br/>
    Reflex: <%=personage.getModReflex()%><br/>
    Will: <%=personage.getModWill()%><br/>
    Class: <%=personage.getPersonageClass()%><br/>
    Race: <%=personage.getRace()%><br/>
    Strenght: <%=personage.getModStrenght()%><br/>
    Dexterity: <%=personage.getModDexterity()%><br/>
    Constitution: <%=personage.getModConstitution()%><br/>
    Intelligence: <%=personage.getModIntelligence()%><br/>
    Wisdom: <%=personage.getModWisdom()%><br/>
    Charisma: <%=personage.getModCharisma()%><br/>
    <h3>Weapons:</h3>
    <ul>
        <%
            for (WeaponOfPersonageEntity weaponOfPersonage : personage.getWeapons()) {
                WeaponEntity weapon = weaponOfPersonage.getWeapon();
        %>
                <li>
                    <i><%=weapon.getName()%></i><br/>
                    type: <%=weapon.getTypeOfWeapon()%><br/>
                    attack bonus: <%=weapon.getAttackBonus()%><br/>
                    critical bonus: x<%=weapon.getCriticalBonus()%><br/>
                    range: <%=weapon.getRangeOfWeapon()%><br/>
                    damage: <%=weapon.getDamage()%><br/>
                </li>
        <%
            }
        %>
    </ul>
</div>
<div>
    <%
        Collection<SpellEntity> spells = personage.getPersonageClass().getSpells();
        if (!spells.isEmpty()) {
    %>
    <h3>Spells:</h3>
    <ul>
        <%
            for (SpellEntity spell : spells) {
        %>
        <li>
            <i><%=spell.getName()%></i><br/>
            <%=spell.getDescription()%>
        </li>
        <%
            }
        %>
    </ul>
    <%
        }
    %>
</div>
<a href="${pageContext.request.contextPath}/entities?action=delete&type=Personage&id=<%=personageId%>">Delete</a>
<%}%>
</body>
</html>
