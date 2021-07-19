package fr.diginamic.projet.Entity;

import fr.diginamic.projet.Entity.Enumeration.StatutType;
import fr.diginamic.projet.Exception.AbsenceException;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@DiscriminatorValue("conge_paye")
public class CongePaye extends AbsenceChoisie {

    public static final int NOMBRE_MAX = 25;

    public CongePaye() throws AbsenceException {
    }

    public CongePaye(LocalDate dateDebut, LocalDate dateFin, String motif) throws AbsenceException {
        super(dateDebut, dateFin, motif);
    }

    public CongePaye(StatutType statut, LocalDate dateDebut, LocalDate dateFin, String motif) throws AbsenceException {
        super(statut, dateDebut, dateFin, motif);
    }

    public CongePaye(Long id, StatutType statut, LocalDate dateDebut, LocalDate dateFin, String motif) throws AbsenceException {
        super(id, statut, dateDebut, dateFin, motif);
    }


    @Override
    public void isValid() throws AbsenceException {
        super.isValid();
        if (ChronoUnit.DAYS.between(dateDebut, dateFin.plusDays(1)) > NOMBRE_MAX) {
            throw new AbsenceException("Vous ne pouvez pas poser + de " + NOMBRE_MAX + " jours de Rtt employé");
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
