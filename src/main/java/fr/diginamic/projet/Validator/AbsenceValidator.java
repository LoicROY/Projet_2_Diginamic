package fr.diginamic.projet.Validator;

import fr.diginamic.projet.Entity.Absence;
import fr.diginamic.projet.Exception.AbsenceException;

public class AbsenceValidator {

    public static void isValid(Absence absence) throws AbsenceException {
        absence.isValid();
    }
}
