package fr.diginamic.projet.Entity;

import fr.diginamic.projet.Entity.Enumeration.StatutType;
import fr.diginamic.projet.Exception.AbsenceException;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("conge_sans_solde")
public class CongeSansSolde extends AbsenceChoisie {

    public CongeSansSolde() throws AbsenceException {
    }

    public CongeSansSolde(LocalDate dateDebut, LocalDate dateFin, String motif) throws AbsenceException {
        super(dateDebut, dateFin, motif);
    }

    public CongeSansSolde(StatutType statut, LocalDate dateDebut, LocalDate dateFin, String motif) throws AbsenceException {
        super(statut, dateDebut, dateFin, motif);
    }

    public CongeSansSolde(Long id, StatutType statut, LocalDate dateDebut, LocalDate dateFin, String motif) throws AbsenceException {
        super(id, statut, dateDebut, dateFin, motif);
    }


    @Override
    public String toString() {
        return "CongeSansSolde{" +
                "statut=" + statut +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", motif='" + motif + '\'' +
                ", id=" + id +
                '}';
    }
}
