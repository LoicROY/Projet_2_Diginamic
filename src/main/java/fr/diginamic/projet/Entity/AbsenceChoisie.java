package fr.diginamic.projet.Entity;

import fr.diginamic.projet.Entity.Enumeration.StatutType;
import fr.diginamic.projet.Exception.AbsenceException;
import fr.diginamic.projet.Utils.DateUtils;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
public abstract class AbsenceChoisie extends Absence {

    @Column(name = "date_debut")
    protected LocalDate dateDebut;
    @Column(name = "date_fin")
    protected LocalDate dateFin;
    @Column(name = "motif")
    protected String motif;

    protected AbsenceChoisie() throws AbsenceException {
        this(null, null, null, null, null);
    }

    protected AbsenceChoisie(LocalDate dateDebut, LocalDate dateFin, String motif) throws AbsenceException {
        this(null, null, dateDebut, dateFin, motif);
    }

    protected AbsenceChoisie(StatutType statut, LocalDate dateDebut, LocalDate dateFin, String motif) throws AbsenceException {
        this(null, statut, dateDebut, dateFin, motif);
    }

    public AbsenceChoisie(Long id, StatutType statut, LocalDate dateDebut, LocalDate dateFin, String motif) throws AbsenceException {
        super(id, statut);
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.motif = motif;
//        isValid();
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
    public void isValid() throws AbsenceException {
        if (dateFin.isBefore(dateDebut)){
            throw new AbsenceException("La date de fin ne peut pas être avant la date de début");
        }
        if (dateDebut.isBefore(LocalDate.now()) || dateDebut.isEqual(LocalDate.now())){
            throw new AbsenceException("La date de début ne peut pas être aujourd'hui");
        }
        if (DateUtils.isSaturdayOrSunday(dateDebut) || DateUtils.isSaturdayOrSunday(dateFin)) {
            throw new AbsenceException("Vous ne pouvez pas poser d'absence qui commence ou finis un week end'");
        }
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
