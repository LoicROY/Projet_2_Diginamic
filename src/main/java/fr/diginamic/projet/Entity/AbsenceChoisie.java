package fr.diginamic.projet.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.diginamic.projet.Entity.Enumeration.StatutType;
import fr.diginamic.projet.Exception.AbsenceException;
import fr.diginamic.projet.Utils.DateUtils;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
public abstract class AbsenceChoisie extends Absence {

    @Column(name = "date_debut")
    @JsonProperty(required = true)
    protected LocalDate dateDebut;
    @Column(name = "date_fin")
    protected LocalDate dateFin;
    @Column(name = "motif")
    protected String motif;

    protected AbsenceChoisie() {
        super();
    }

    protected AbsenceChoisie(LocalDate dateDebut, LocalDate dateFin, String motif) {
        this(null, null, dateDebut, dateFin, motif);
    }

    protected AbsenceChoisie(StatutType statut, LocalDate dateDebut, LocalDate dateFin, String motif) {
        this(null, statut, dateDebut, dateFin, motif);
    }

    public AbsenceChoisie(Long id, StatutType statut, LocalDate dateDebut, LocalDate dateFin, String motif) {
        super(id, statut);
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
    public void isValid() throws AbsenceException {
        if (dateDebut == null || dateFin == null){
            throw new AbsenceException("Les dates de début et de fin doivent être valorisées");
        }
        if (dateFin.isBefore(dateDebut)){
            throw new AbsenceException("La date de fin ne peut pas être avant la date de début");
        }
        if (!dateDebut.isAfter(LocalDate.now())){
            throw new AbsenceException("La date de début doit être après aujourd'hui");
        }
        if (DateUtils.isSaturdayOrSunday(dateDebut) || DateUtils.isSaturdayOrSunday(dateFin)) {
            throw new AbsenceException("Vous ne pouvez pas poser d'absence qui commence ou finis un week end");
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
