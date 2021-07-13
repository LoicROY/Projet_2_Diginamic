package fr.diginamic.projet.Entity;

import fr.diginamic.projet.Entity.Enumeration.StatutType;

import java.time.LocalDate;

public abstract class AbsenceChoisie extends Absence {

    protected LocalDate dateDebut;
    protected LocalDate dateFin;
    protected String motif;

    protected AbsenceChoisie() {
    }

    protected AbsenceChoisie(LocalDate dateDebut, LocalDate dateFin, String motif) {
        this(null, dateDebut, dateFin, motif);
    }

    protected AbsenceChoisie(StatutType statut, LocalDate dateDebut, LocalDate dateFin, String motif) {
        super(statut);
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.motif = motif;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    @Override
    public String toString() {
        return "AbsenceChoisie{" +
                "statut=" + statut +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", motif='" + motif + '\'' +
                ", id=" + id +
                '}';
    }
}
