package fr.diginamic.projet.Entity;

import fr.diginamic.projet.Entity.Enumeration.StatutType;
import fr.diginamic.projet.Exception.AbsenceException;
import fr.diginamic.projet.Utils.DateUtils;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("rtt_employeur")
public class RttEmployeur extends AbsenceObligatoire {


    public static final int NOMBRE_MAX = 25;

    public RttEmployeur() throws AbsenceException {
    }

    public RttEmployeur(LocalDate date, String libelle) throws AbsenceException {
        super(date, libelle);
    }

    public RttEmployeur(StatutType statut, LocalDate date, String libelle) throws AbsenceException {
        super(statut, date, libelle);
    }

    public RttEmployeur(Long id, StatutType statut, LocalDate date, String libelle) throws AbsenceException {
        super(id, statut, date, libelle);
    }

    @Override
    public void isValid() throws AbsenceException {
        super.isValid();
        if (DateUtils.isSaturdayOrSunday(date)) {
            throw new AbsenceException("Vous ne pouvez pas poser de Rtt Employeur le week end");
        }
    }

    @Override
    public String toString() {
        return "RttEmployeur{" +
                "statut=" + statut +
                ", date=" + date +
                ", jour=" + jour +
                ", libelle='" + libelle + '\'' +
                ", id=" + id +
                '}';
    }

}
