package fr.diginamic.projet.Entity;

import fr.diginamic.projet.Entity.Enumeration.StatutType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("conge_anticipe")
public class CongeAnticipe extends AbsenceChoisie {

    public CongeAnticipe() {
    }

    public CongeAnticipe(LocalDate dateDebut, LocalDate dateFin, String motif) {
        super(dateDebut, dateFin, motif);
    }

    public CongeAnticipe(StatutType statut, LocalDate dateDebut, LocalDate dateFin, String motif) {
        super(statut, dateDebut, dateFin, motif);
    }

    public CongeAnticipe(Long id, StatutType statut, LocalDate dateDebut, LocalDate dateFin, String motif) {
        super(id, statut, dateDebut, dateFin, motif);
    }


    @Override
    public String toString() {
        return "CongeAnticipe{" +
                "statut=" + statut +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", motif='" + motif + '\'' +
                ", id=" + id +
                '}';
    }
}
