package fr.diginamic.projet.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@DiscriminatorValue("A")
public class Administrateur extends Salarie {

    private String Libelle;
    private AbsenceObligatoire typeAbsence;

    public Absence addJourFerieOrRtt(LocalDate date, String libelle,AbsenceObligatoire typeAbsence){
        return null;
    }


}
