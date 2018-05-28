package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "PERSONAGE", schema = "TEST")
public class PersonageEntity extends PrettyEntity {
    private long id;
    private String name;
    private Long xp;
    private Long level;
    private String alignment;
    private Long hp;
    private Long age;
    private Long modAcrobatics;
    private Long modBluff;
    private Long modPerception;
    private Long modDiplomacy;
    private Long modSpellcraft;
    private Long valStrenght;
    private Long valDexterity;
    private Long valConstitution;
    private Long valIntelligence;
    private Long valWisdom;
    private Long valCharisma;
    private Long modFortitude;
    private Long modReflex;
    private Long modWill;
    private PersonageClassEntity personageClass;
    private RaceEntity race;
    private PlayerEntity owner;
    private Collection<WeaponOfPersonageEntity> weapons;

    @Id
    @Column(name = "PERSONAGEID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PERSONAGENAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "PERSONAGEXP")
    public long getXp() {
        return xp;
    }

    public void setXp(long xp) {
        this.xp = xp;
    }

    @Basic
    @Column(name = "PERSONAGELEVEL")
    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    @Basic
    @Column(name = "PERSONAGEALIGNMENT")
    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    @Basic
    @Column(name = "HP")
    public long getHp() {
        return hp;
    }

    public void setHp(long hp) {
        this.hp = hp;
    }

    @Basic
    @Column(name = "AGE")
    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    @Basic
    @Column(name = "MODACROBATICS")
    public long getModAcrobatics() {
        return modAcrobatics;
    }

    public void setModAcrobatics(long modAcrobatics) {
        this.modAcrobatics = modAcrobatics;
    }

    @Basic
    @Column(name = "MODBLUFF")
    public long getModBluff() {
        return modBluff;
    }

    public void setModBluff(long modBluff) {
        this.modBluff = modBluff;
    }

    @Basic
    @Column(name = "MODPERCEPTION")
    public long getModPerception() {
        return modPerception;
    }

    public void setModPerception(long modPerception) {
        this.modPerception = modPerception;
    }

    @Basic
    @Column(name = "MODDIPLOMACY")
    public long getModDiplomacy() {
        return modDiplomacy;
    }

    public void setModDiplomacy(long modDiplomacy) {
        this.modDiplomacy = modDiplomacy;
    }

    @Basic
    @Column(name = "MODSPELLCRAFT")
    public long getModSpellcraft() {
        return modSpellcraft;
    }

    public void setModSpellcraft(long modSpellcraft) {
        this.modSpellcraft = modSpellcraft;
    }

    @Basic
    @Column(name = "VALSTRENGHT")
    public long getValStrenght() {
        return valStrenght;
    }

    public void setValStrenght(long valStrenght) {
        this.valStrenght = valStrenght;
    }

    @Basic
    @Column(name = "VALDEXTERITY")
    public long getValDexterity() {
        return valDexterity;
    }

    public void setValDexterity(long valDexterity) {
        this.valDexterity = valDexterity;
    }

    @Basic
    @Column(name = "VALCONSTITUTION")
    public long getValConstitution() {
        return valConstitution;
    }

    public void setValConstitution(long valConstitution) {
        this.valConstitution = valConstitution;
    }

    @Basic
    @Column(name = "VALINTELLIGENCE")
    public long getValIntelligence() {
        return valIntelligence;
    }

    public void setValIntelligence(long valIntelligence) {
        this.valIntelligence = valIntelligence;
    }

    @Basic
    @Column(name = "VALWISDOM")
    public long getValWisdom() {
        return valWisdom;
    }

    public void setValWisdom(long valWisdom) {
        this.valWisdom = valWisdom;
    }

    @Basic
    @Column(name = "VALCHARISMA")
    public long getValCharisma() {
        return valCharisma;
    }

    public void setValCharisma(long valCharisma) {
        this.valCharisma = valCharisma;
    }

    @Basic
    @Column(name = "MODFORTITUDE")
    public long getModFortitude() {
        return modFortitude;
    }

    public void setModFortitude(long modFortitude) {
        this.modFortitude = modFortitude;
    }

    @Basic
    @Column(name = "MODREFLEX")
    public long getModReflex() {
        return modReflex;
    }

    public void setModReflex(long modReflex) {
        this.modReflex = modReflex;
    }

    @Basic
    @Column(name = "MODWILL")
    public long getModWill() {
        return modWill;
    }

    public void setModWill(long modWill) {
        this.modWill = modWill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonageEntity that = (PersonageEntity) o;

        if (id != that.id) return false;
        if (personageClass != that.personageClass) return false;
        if (race != that.race) return false;
        if (name != null ? !name.equals(that.name) : that.name != null)
            return false;
        if (level != null ? !level.equals(that.level) : that.level != null)
            return false;
        if (alignment != null ? !alignment.equals(that.alignment) : that.alignment != null)
            return false;
        if (xp != null ? !xp.equals(that.xp) : that.xp != null)
            return false;
        if (hp != null ? !hp.equals(that.hp) : that.hp != null)
            return false;
        if (age != null ? !age.equals(that.age) : that.age != null)
            return false;
        if (modAcrobatics != null ? !modAcrobatics.equals(that.modAcrobatics) : that.modAcrobatics != null)
            return false;
        if (modBluff != null ? !modBluff.equals(that.modBluff) : that.modBluff != null)
            return false;
        if (modPerception != null ? !modPerception.equals(that.modPerception) : that.modPerception != null)
            return false;
        if (modDiplomacy != null ? !modDiplomacy.equals(that.modDiplomacy) : that.modDiplomacy != null)
            return false;
        if (modSpellcraft != null ? !modSpellcraft.equals(that.modSpellcraft) : that.modSpellcraft != null)
            return false;
        if (valStrenght != null ? !valStrenght.equals(that.valStrenght) : that.valStrenght != null)
            return false;
        if (valDexterity != null ? !valDexterity.equals(that.valDexterity) : that.valDexterity != null)
            return false;
        if (valConstitution != null ? !valConstitution.equals(that.valConstitution) : that.valConstitution != null)
            return false;
        if (valIntelligence != null ? !valIntelligence.equals(that.valIntelligence) : that.valIntelligence != null)
            return false;
        if (valWisdom != null ? !valWisdom.equals(that.valWisdom) : that.valWisdom != null)
            return false;
        if (valCharisma != null ? !valCharisma.equals(that.valCharisma) : that.valCharisma != null)
            return false;
        if (modFortitude != null ? !modFortitude.equals(that.modFortitude) : that.modFortitude != null)
            return false;
        if (modReflex != null ? !modReflex.equals(that.modReflex) : that.modReflex != null)
            return false;
        if (modWill != null ? !modWill.equals(that.modWill) : that.modWill != null)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (alignment != null ? alignment.hashCode() : 0);
        result = 31 * result + (hp != null ? hp.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (modAcrobatics != null ? modAcrobatics.hashCode() : 0);
        result = 31 * result + (modBluff != null ? modBluff.hashCode() : 0);
        result = 31 * result + (modPerception != null ? modPerception.hashCode() : 0);
        result = 31 * result + (modDiplomacy != null ? modDiplomacy.hashCode() : 0);
        result = 31 * result + (modSpellcraft != null ? modSpellcraft.hashCode() : 0);
        result = 31 * result + (valStrenght != null ? valStrenght.hashCode() : 0);
        result = 31 * result + (valDexterity != null ? valDexterity.hashCode() : 0);
        result = 31 * result + (valConstitution != null ? valConstitution.hashCode() : 0);
        result = 31 * result + (valIntelligence != null ? valIntelligence.hashCode() : 0);
        result = 31 * result + (valWisdom != null ? valWisdom.hashCode() : 0);
        result = 31 * result + (valCharisma != null ? valCharisma.hashCode() : 0);
        result = 31 * result + (modFortitude != null ? modFortitude.hashCode() : 0);
        result = 31 * result + (modReflex != null ? modReflex.hashCode() : 0);
        result = 31 * result + (modWill != null ? modWill.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONAGECLASS", referencedColumnName = "PERSONAGECLASSID", nullable = false)
    public PersonageClassEntity getPersonageClass() {
        return personageClass;
    }

    public void setPersonageClass(PersonageClassEntity personageClass) {
        this.personageClass = personageClass;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONAGERACE", referencedColumnName = "RACEID", nullable = false)
    public RaceEntity getRace() {
        return race;
    }

    public void setRace(RaceEntity race) {
        this.race = race;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONAGEOWNERID", referencedColumnName = "PLAYERID")
    public PlayerEntity getOwner() {
        return owner;
    }

    public void setOwner(PlayerEntity owner) {
        this.owner = owner;
    }

    @OneToMany(mappedBy = "personage")
    public Collection<WeaponOfPersonageEntity> getWeapons() {
        return weapons;
    }

    public void setWeapons(Collection<WeaponOfPersonageEntity> weapons) {
        this.weapons = weapons;
    }

    @Override
    public long primaryKey() {
        return id;
    }

    public static Long calculateLevel(Long xp) {
        return (xp / 2000) + 1;
    }
}
