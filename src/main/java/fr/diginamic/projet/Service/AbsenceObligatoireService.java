package fr.diginamic.projet.Service;

import fr.diginamic.projet.Entity.AbsenceObligatoire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AbsenceObligatoireService {
    @Autowired
    private JourFerieService jourFerieService;
    @Autowired
    private RttEmployeurService rttEmployeurService;

    public List<AbsenceObligatoire> findAll() {
        List<AbsenceObligatoire> absenceObligatoires = new ArrayList<>(rttEmployeurService.findAll());
        absenceObligatoires.addAll(jourFerieService.findAll());
        return absenceObligatoires;
    }

}
