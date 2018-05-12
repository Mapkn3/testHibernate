package entities;

import javax.persistence.*;

@Entity
@Table(name = "WEAPONOFPERSONAGE", schema = "TEST")
public class WeaponOfPersonageEntity extends PrettyEntity {
    private long id;
    private PersonageEntity personage;
    private WeaponEntity weapon;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeaponOfPersonageEntity that = (WeaponOfPersonageEntity) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @ManyToOne
    @JoinColumn(name = "PERSONAGEID", referencedColumnName = "PERSONAGEID", nullable = false)
    public PersonageEntity getPersonage() {
        return personage;
    }

    public void setPersonage(PersonageEntity personage) {
        this.personage = personage;
    }

    @ManyToOne
    @JoinColumn(name = "WEAPONID", referencedColumnName = "WEAPONID", nullable = false)
    public WeaponEntity getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponEntity weapon) {
        this.weapon = weapon;
    }

    @Override
    public long primaryKey() {
        return id;
    }
}
