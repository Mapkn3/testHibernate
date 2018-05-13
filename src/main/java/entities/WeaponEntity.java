package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "WEAPON", schema = "TEST")
public class WeaponEntity extends PrettyEntity{
    private long id;
    private String name;
    private Long attackBonus;
    private Long criticalBonus;
    private String typeOfWeapon;
    private Long rangeOfWeapon;
    private String damage;

    @Id
    @Column(name = "WEAPONID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAMEOFWEAPON")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ATTACKBONUS")
    public Long getAttackBonus() {
        return attackBonus;
    }

    public void setAttackBonus(Long attackBonus) {
        this.attackBonus = attackBonus;
    }

    @Basic
    @Column(name = "CRITICALBONUS")
    public Long getCriticalBonus() {
        return criticalBonus;
    }

    public void setCriticalBonus(Long criticalBonus) {
        this.criticalBonus = criticalBonus;
    }

    @Basic
    @Column(name = "TYPEOFWEAPON")
    public String getTypeOfWeapon() {
        return typeOfWeapon;
    }

    public void setTypeOfWeapon(String typeOfWeapon) {
        this.typeOfWeapon = typeOfWeapon;
    }

    @Basic
    @Column(name = "RANGEOFWEAPON")
    public Long getRangeOfWeapon() {
        return rangeOfWeapon;
    }

    public void setRangeOfWeapon(Long rangeOfWeapon) {
        this.rangeOfWeapon = rangeOfWeapon;
    }

    @Basic
    @Column(name = "DAMAGE")
    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeaponEntity that = (WeaponEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (attackBonus != null ? !attackBonus.equals(that.attackBonus) : that.attackBonus != null) return false;
        if (criticalBonus != null ? !criticalBonus.equals(that.criticalBonus) : that.criticalBonus != null)
            return false;
        if (typeOfWeapon != null ? !typeOfWeapon.equals(that.typeOfWeapon) : that.typeOfWeapon != null) return false;
        if (rangeOfWeapon != null ? !rangeOfWeapon.equals(that.rangeOfWeapon) : that.rangeOfWeapon != null)
            return false;
        if (damage != null ? !damage.equals(that.damage) : that.damage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (attackBonus != null ? attackBonus.hashCode() : 0);
        result = 31 * result + (criticalBonus != null ? criticalBonus.hashCode() : 0);
        result = 31 * result + (typeOfWeapon != null ? typeOfWeapon.hashCode() : 0);
        result = 31 * result + (rangeOfWeapon != null ? rangeOfWeapon.hashCode() : 0);
        result = 31 * result + (damage != null ? damage.hashCode() : 0);
        return result;
    }

    @Override
    public long primaryKey() {
        return id;
    }
}
