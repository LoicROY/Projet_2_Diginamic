package fr.diginamic.projet.Entity;

import fr.diginamic.projet.Entity.Enumeration.StatutType;
import fr.diginamic.projet.Exception.AbsenceException;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("jour_ferie")
public class JourFerie extends AbsenceObligatoire {

    public JourFerie() {
    }

    public JourFerie(LocalDate date, String libelle) {
        super(date, libelle);
    }

    public JourFerie(StatutType statut, LocalDate date, String libelle) {
        super(statut, date, libelle);
    }

    public JourFerie(Long id, StatutType statut, LocalDate date, String libelle) {
        super(id, statut, date, libelle);
    }

    @Override
    public String toString() {
        return "JourFerie{" +
                "statut=" + statut +
                ", date=" + date +
                ", jour=" + jour +
                ", libelle='" + libelle + '\'' +
                ", id=" + id +
                '}';
    }
}
