package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Service.AbsenceService;
import fr.diginamic.projet.Service.NightBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchController {

    @Autowired
    private NightBatchService service;
    @Autowired
    private AbsenceService absenceService;
    private static final String EUROPE_PARIS = "Europe/Paris";


    @Scheduled(cron = "0 0 0 * * ?", zone = EUROPE_PARIS)
//    @Scheduled(cron = "@midnight", zone = EUROPE_PARIS)
    @GetMapping("/batch")
    public void traiter() {
        service.traiterAbsenceChoisie();
        service.traiterAbsenceObligatoire();
    }

    //https://spring.io/blog/2020/11/10/new-in-spring-5-3-improved-cron-expressions
    @Scheduled(cron = "@yearly", zone = EUROPE_PARIS)
    @GetMapping("/sqlResetBatch")
    public void sqlReset() {
        absenceService.reset();
    }

}
