package fr.diginamic.projet.Entity;

import fr.diginamic.projet.Entity.Enumeration.StatutType;

import java.time.LocalDate;

public class AbsenceObligatoire extends Absence {

    protected LocalDate date;
    protected LocalDate jour;
    protected String libelle;

    protected AbsenceObligatoire() {
    }

    protected AbsenceObligatoire(LocalDate date, LocalDate jour, String libelle) {
        this(null, null, date, jour, libelle);
    }

    protected AbsenceObligatoire(StatutType statut, LocalDate date, LocalDate jour, String libelle) {
        this(null, statut, date, jour, libelle);
    }

    protected AbsenceObligatoire(Long id, StatutType statut, LocalDate date, LocalDate jour, String libelle) {
        super(id, statut);
        this.date = date;
        this.jour = jour;
        this.libelle = libelle;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getJour() {
        return jour;
    }

    public void setJour(LocalDate jour) {
        this.jour = jour;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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
