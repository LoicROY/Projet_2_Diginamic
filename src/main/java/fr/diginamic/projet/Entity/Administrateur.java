package fr.diginamic.projet.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@DiscriminatorValue("administrateur")
public class Administrateur extends Salarie {



   /* public Absence addJourFerieOrRtt(LocalDate date, String libelle,AbsenceObligatoire typeAbsence){
        return addJourFerieOrRtt();
    }*/


}
