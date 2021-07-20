package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Exception.AbsenceException;
import fr.diginamic.projet.Service.NightBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NightBatchController  {

    @Autowired
    private NightBatchService service;
    private static final String EUROPE_PARIS = "Europe/Paris";


    @Scheduled(cron = "0 0 23 * * ?",zone = EUROPE_PARIS)
    @GetMapping("/batch")
    public void traiter() throws AbsenceException {
        service.traiterAbsenceChoisie();
        service.traiterAbsenceObligatoire();
    }

}