package fr.diginamic.projet.Service;

import fr.diginamic.projet.Entity.AbsenceChoisie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AbsenceChoisieService {
    @Autowired
    private CongeSansSoldeService congeSansSoldeService;
    @Autowired
    private CongePayeService congePayeService;
    @Autowired
    private RttEmployeService rttEmployeService;

    public List<AbsenceChoisie> findAll() {
        List<AbsenceChoisie> absenceChoisies = new ArrayList<>(rttEmployeService.findAll());
        List<AbsenceChoisie> congesSansSolde = new ArrayList<>(congeSansSoldeService.findAll());
        absenceChoisies.addAll(congesSansSolde);
        List<AbsenceChoisie> congesPayes = new ArrayList<>(congePayeService.findAll());
        absenceChoisies.addAll(congesPayes);
        return absenceChoisies;
    }
}
