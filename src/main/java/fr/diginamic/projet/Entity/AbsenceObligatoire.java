package fr.diginamic.projet.Entity;

import fr.diginamic.projet.Entity.Enumeration.StatutType;
import fr.diginamic.projet.Exception.AbsenceException;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;

@MappedSuperclass
public abstract class AbsenceObligatoire extends Absence {

    @Column(name = "date_absence")
    protected LocalDate date;
    @Column(name = "jour")
    @Enumerated(value = EnumType.STRING)
    protected DayOfWeek jour;
    @Column(name = "libelle")
    protected String libelle;

    protected AbsenceObligatoire() {
        this(null, null, null, null);
    }

    protected AbsenceObligatoire(LocalDate date, String libelle) {
        this(null, null, date, libelle);
    }

    protected AbsenceObligatoire(StatutType statut, LocalDate date, String libelle) {
        this(null, statut, date, libelle);
    }

    protected AbsenceObligatoire(Long id, StatutType statut, LocalDate date, String libelle) {
        super(id, statut);
        this.date = date;
        if (date != null){
            this.jour = date.getDayOfWeek();
        }
        this.libelle = libelle;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public DayOfWeek getJour() {
        return jour;
    }

    public void setJour(DayOfWeek jour) {
        this.jour = jour;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public void isValid() throws AbsenceException {
    }

    @Override
    public String toString() {
        return "AbsenceObligatoire{" +
                "statut=" + statut +
                ", date=" + date +
                ", jour=" + jour +
                ", libelle='" + libelle + '\'' +
                ", id=" + id +
                '}';
    }
}
