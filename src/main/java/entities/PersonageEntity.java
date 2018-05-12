package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "PERSONAGE", schema = "TEST")
public class PersonageEntity extends PrettyEntity {
    private long id;
    private String name;
    private Long level;
    private String alignment;
    private String characteristics;
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
    @Column(name = "PERSONAGELEVEL")
    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
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
    @Column(name = "PERSONAGECHARACTERISTICS")
    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
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
        if (characteristics != null ? !characteristics.equals(that.characteristics) : that.characteristics != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (alignment != null ? alignment.hashCode() : 0);
        result = 31 * result + (characteristics != null ? characteristics.hashCode() : 0);
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
}
