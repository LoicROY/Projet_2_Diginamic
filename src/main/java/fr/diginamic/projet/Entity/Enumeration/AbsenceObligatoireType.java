package fr.diginamic.projet.Entity.Enumeration;

import fr.diginamic.projet.Entity.AbsenceChoisie;
import fr.diginamic.projet.Entity.AbsenceObligatoire;
import fr.diginamic.projet.Entity.JourFerie;
import fr.diginamic.projet.Entity.RttEmployeur;

public enum AbsenceObligatoireType {
    RTT_EMPLOYEUR(RttEmployeur.class),
    JOUR_FERIE(JourFerie.class);

    private final Class<? extends AbsenceObligatoire> CLASS;

    AbsenceObligatoireType(Class<? extends AbsenceObligatoire> classType) {
        this.CLASS = classType;
    }

    public Class<? extends AbsenceObligatoire> getClassType() {
        return CLASS;
    }
}
