package fr.diginamic.projet.Entity;

import fr.diginamic.projet.Entity.Enumeration.StatutType;
import fr.diginamic.projet.Exception.AbsenceException;
import fr.diginamic.projet.Utils.DateUtils;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("conge_paye")
public class CongePaye extends AbsenceChoisie {

    public static final int NOMBRE_MAX = 25;

    public CongePaye() {
    }

    public CongePaye(LocalDate dateDebut, LocalDate dateFin, String motif) {
        super(dateDebut, dateFin, motif);
    }

    public CongePaye(StatutType statut, LocalDate dateDebut, LocalDate dateFin, String motif) {
        super(statut, dateDebut, dateFin, motif);
    }

    public CongePaye(Long id, StatutType statut, LocalDate dateDebut, LocalDate dateFin, String motif) {
        super(id, statut, dateDebut, dateFin, motif);
    }

    public CongePaye(Long id, StatutType statut, LocalDate dateDebut, LocalDate dateFin, String motif, Salarie salarie) {
        super(id, statut, dateDebut, dateFin, motif);
        this.salarie = salarie;
    }

    @Override
    public void isValid() throws AbsenceException {
        super.isValid();
        if (DateUtils.workedDaysBetween(dateDebut, dateFin) > NOMBRE_MAX) {
            throw new AbsenceException("Vous ne pouvez pas poser + de " + NOMBRE_MAX + " jours de Congé payé");
        }
    }

    @Override
    public String toString() {
        return "CongePaye{" +
                "statut=" + statut +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", motif='" + motif + '\'' +
                ", id=" + id +
                '}';
    }
}
