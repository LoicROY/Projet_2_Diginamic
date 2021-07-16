package fr.diginamic.projet.Entity;

import fr.diginamic.projet.Entity.Enumeration.StatutType;
import fr.diginamic.projet.Exception.AbsenceException;

import javax.persistence.*;

@Entity
@Table(name = "ABSENCE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminant", discriminatorType = DiscriminatorType.STRING)
public abstract class Absence extends BasedEntity {

    @Column(name = "statut", nullable = false)
    @Enumerated(value = EnumType.STRING)
    protected StatutType statut;

    protected Absence() {
        this(null, null);
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

    public abstract void isValid() throws AbsenceException;

    @Override
    public String toString() {
        return "Absence{" +
                "statut=" + statut +
                ", id=" + id +
                '}';
    }
}
