package fr.diginamic.projet.Service;

import fr.diginamic.projet.Entity.Absence;
import fr.diginamic.projet.Entity.CongePaye;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AbsenceService extends CrudService<Absence> {

    @Autowired
    private CongePayeService congePayeService;
    @Autowired
    private RttEmployeService rttEmployeService;
    @Autowired
    private CongeAnticipeService congeAnticipeService;


    public void reset() {
        congePayeService.deleteAll();
        rttEmployeService.deleteAll();
        congePayeService.saveAll(
                congeAnticipeService.findAll().stream()
                        .map(congeAnticipe -> new CongePaye(
                                congeAnticipe.getId(),
                                congeAnticipe.getStatut(),
                                congeAnticipe.getDateDebut(),
                                congeAnticipe.getDateFin(),
                                congeAnticipe.getMotif(),
                                congeAnticipe.getSalarie()
                        ))
                        .collect(Collectors.toList())
        );
        congeAnticipeService.deleteAll();
    }
}
