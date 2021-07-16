package fr.diginamic.projet.Entity;

import fr.diginamic.projet.Entity.Enumeration.StatutType;
import fr.diginamic.projet.Exception.AbsenceException;
import fr.diginamic.projet.Utils.DateUtils;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.Month;

@Entity
@DiscriminatorValue("rtt_employe")
public class RttEmploye extends AbsenceChoisie {

    private static final int LAST_DAY_OF_MONTH = 31;
    private static final LocalDate DATE_MAX =
            LocalDate.of(LocalDate.MAX.getYear(), Month.DECEMBER, LAST_DAY_OF_MONTH);
    public static final int NOMBRE_MAX = 6;

    public RttEmploye() throws AbsenceException {
    }

    public RttEmploye(LocalDate dateDebut, LocalDate dateFin, String motif) throws AbsenceException {
        super(dateDebut, dateFin, motif);
    }

    public RttEmploye(StatutType statut, LocalDate dateDebut, LocalDate dateFin, String motif) throws AbsenceException {
        super(statut, dateDebut, dateFin, motif);
    }

    public RttEmploye(Long id, StatutType statut, LocalDate dateDebut, LocalDate dateFin, String motif) throws AbsenceException {
        super(id, statut, dateDebut, dateFin, motif);
    }


    public static LocalDate getDateMax() {
        return DATE_MAX.withYear(LocalDate.now().getYear());
    }

    @Override
    public void isValid() throws AbsenceException {
        super.isValid();
        if (DateUtils.daysBetween(dateDebut, dateFin) > NOMBRE_MAX) {
            throw new AbsenceException("Vous ne pouvez pas poser + de " + NOMBRE_MAX + " jours de Rtt employé");
        }
        if (dateDebut.isAfter(getDateMax())) {
            throw new AbsenceException("Vous ne pouvez pas poser de Rtt employé après le " +
                    DateUtils.format(getDateMax()));
        }
    }

    @Override
    public String toString() {
        return "RttEmploye{" +
                "statut=" + statut +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", motif='" + motif + '\'' +
                ", id=" + id +
                '}';
    }
}
