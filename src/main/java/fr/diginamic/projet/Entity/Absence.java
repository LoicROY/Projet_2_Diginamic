package fr.diginamic.projet.Entity;

import fr.diginamic.projet.Entity.Enumeration.StatutType;

public abstract class Absence extends BasedEntity {

    protected StatutType statut;

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
