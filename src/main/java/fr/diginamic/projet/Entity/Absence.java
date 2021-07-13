package fr.diginamic.projet.Entity;

import fr.diginamic.projet.Entity.Enumeration.StatutType;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;
@Entity
public abstract class Absence extends BasedEntity {

    protected StatutType statut;


    @ManyToMany(mappedBy = "absences")
    protected Set<Salarie> salaries = new HashSet<>();

    protected Absence() {
    }

    protected Absence(StatutType statut) {
        this(null, statut);
    }

    protected Absence(Long id, StatutType statut) {
        super(id);
        this.statut = statut;
    }

    public StatutType getStatut() {
        return statut;
    }

    public void setStatut(StatutType statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Absence{" +
                "statut=" + statut +
                ", id=" + id +
                '}';
    }
}
