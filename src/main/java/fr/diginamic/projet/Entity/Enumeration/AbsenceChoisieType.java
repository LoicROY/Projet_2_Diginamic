package fr.diginamic.projet.Entity.Enumeration;

import fr.diginamic.projet.Entity.AbsenceChoisie;
import fr.diginamic.projet.Entity.CongePaye;
import fr.diginamic.projet.Entity.CongeSansSolde;
import fr.diginamic.projet.Entity.RttEmploye;

public enum AbsenceChoisieType {
    RTT_EMPLOYE(RttEmploye.class),
    CONGE_PAYE(CongePaye.class),
    CONGE_SANS_SOLDE(CongeSansSolde.class);

    private final Class<? extends AbsenceChoisie> CLASS;

    AbsenceChoisieType(Class<? extends AbsenceChoisie> classType) {
        this.CLASS = classType;
    }

    public Class<? extends AbsenceChoisie> getClassType() {
        return CLASS;
    }
}
