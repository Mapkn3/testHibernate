package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "PERSONAGECLASS", schema = "TEST")
public class PersonageClassEntity extends PrettyEntity {
    private long id;
    private String name;
    private String features;
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

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (features != null ? features.hashCode() : 0);
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
