package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "PERSONAGECLASS", schema = "TEST")
public class PersonageClassEntity extends PrettyEntity {
    private long id;
    private String name;
    private String features;
    private Long maxHp;
    private String researchAcrobatics;
    private String researchBluff;
    private String researchPerception;
    private String researchDiplomacy;
    private String researchSpellcraft;
    private Long baseAttackBonus;
    private Collection<SpellEntity> spells;

    @Id
    @Column(name = "PERSONAGECLASSID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PERSONAGECLASSNAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "PERSONAGECLASSFEATURES")
    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    @Basic
    @Column(name = "MAXHP")
    public long getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(long maxHp) {
        this.maxHp = maxHp;
    }

    @Basic
    @Column(name = "RESEARCHACROBATICS")
    public String getResearchAcrobatics() {
        return researchAcrobatics;
    }

    public void setResearchAcrobatics(String researchAcrobatics) {
        this.researchAcrobatics = researchAcrobatics;
    }

    @Basic
    @Column(name = "RESEARCHBLUFF")
    public String getResearchBluff() {
        return researchBluff;
    }

    public void setResearchBluff(String researchBluff) {
        this.researchBluff = researchBluff;
    }

    @Basic
    @Column(name = "RESEARCHPERCEPTION")
    public String getResearchPerception() {
        return researchPerception;
    }

    public void setResearchPerception(String researchPerception) {
        this.researchPerception = researchPerception;
    }

    @Basic
    @Column(name = "RESEARCHDIPLOMACY")
    public String getResearchDiplomacy() {
        return researchDiplomacy;
    }

    public void setResearchDiplomacy(String researchDiplomacy) {
        this.researchDiplomacy = researchDiplomacy;
    }

    @Basic
    @Column(name = "RESEARCHSPELLCRAFT")
    public String getResearchSpellcraft() {
        return researchSpellcraft;
    }

    public void setResearchSpellcraft(String researchSpellcraft) {
        this.researchSpellcraft = researchSpellcraft;
    }

    @Basic
    @Column(name = "BASEATTACKBONUS")
    public long getBaseAttackBonus() {
        return baseAttackBonus;
    }

    public void setBaseAttackBonus(long baseAttackBonus) {
        this.baseAttackBonus = baseAttackBonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonageClassEntity that = (PersonageClassEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null)
            return false;
        if (features != null ? !features.equals(that.features) : that.features != null)
            return false;
        if (maxHp != null ? !maxHp.equals(that.maxHp) : that.maxHp != null)
            return false;
        if (researchAcrobatics != null ? !researchAcrobatics.equals(that.researchAcrobatics) : that.researchAcrobatics != null)
            return false;
        if (researchBluff != null ? !researchBluff.equals(that.researchBluff) : that.researchBluff != null)
            return false;
        if (researchPerception != null ? !researchPerception.equals(that.researchPerception) : that.researchPerception != null)
            return false;
        if (researchDiplomacy != null ? !researchDiplomacy.equals(that.researchDiplomacy) : that.researchDiplomacy != null)
            return false;
        if (researchSpellcraft != null ? !researchSpellcraft.equals(that.researchSpellcraft) : that.researchSpellcraft != null)
            return false;
        if (baseAttackBonus != null ? !baseAttackBonus.equals(that.baseAttackBonus) : that.baseAttackBonus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (features != null ? features.hashCode() : 0);
        result = 31 * result + (maxHp != null ? maxHp.hashCode() : 0);
        result = 31 * result + (researchAcrobatics != null ? researchAcrobatics.hashCode() : 0);
        result = 31 * result + (researchBluff != null ? researchBluff.hashCode() : 0);
        result = 31 * result + (researchPerception != null ? researchPerception.hashCode() : 0);
        result = 31 * result + (researchDiplomacy != null ? researchDiplomacy.hashCode() : 0);
        result = 31 * result + (researchSpellcraft != null ? researchSpellcraft.hashCode() : 0);
        result = 31 * result + (baseAttackBonus != null ? baseAttackBonus.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "personageClass")
    public Collection<SpellEntity> getSpells() {
        return spells;
    }

    public void setSpells(Collection<SpellEntity> spells) {
        this.spells = spells;
    }

    @Override
    public long primaryKey() {
        return id;
    }
}
