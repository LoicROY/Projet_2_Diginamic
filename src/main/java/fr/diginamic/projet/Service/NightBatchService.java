package fr.diginamic.projet.Service;

import fr.diginamic.projet.Entity.*;
import fr.diginamic.projet.Entity.Enumeration.StatutType;
import fr.diginamic.projet.Exception.AbsenceException;
import fr.diginamic.projet.Repository.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class NightBatchService {
    @Autowired
    AbsenceRepository repo;

    public void traiterAbsenceChoisie() throws AbsenceException {
        List<Absence>absences= new ArrayList<>();

      absences = (List<Absence>) repo.findAllByStatut_Initiale();

      for (Absence a : absences ){
          if (a instanceof AbsenceChoisie){
              if (a instanceof CongeSansSolde){
                  a.setStatut(StatutType.EN_ATTENTE_VALIDATION);
                  repo.save(a);
              }
              else if (a instanceof RttEmploye){
                  if ((6 - a.getSalarie().getSoldeRTT()) +  ChronoUnit.DAYS.between(((RttEmploye) a).getDateDebut(), ((RttEmploye) a).getDateFin())<=6){
                      a.setStatut(StatutType.EN_ATTENTE_VALIDATION);
                      repo.save(a);
                  }else{
                      a.setStatut(StatutType.REJETEE);
                      repo.save(a);
                  }
              }
              else if (a instanceof CongePaye){
                  if ((25 - a.getSalarie().getSoldeCP()) +  ChronoUnit.DAYS.between(((CongePaye) a).getDateDebut(), ((CongePaye) a).getDateFin())<=25){
                      a.setStatut(StatutType.EN_ATTENTE_VALIDATION);
                      repo.save(a);
                  }else{
                      a.setStatut(StatutType.REJETEE);
                      repo.save(a);
                  }
              }
          }
      }
    }

    public void traiterAbsenceObligatoire(){
        List<Absence>absences= new ArrayList<>();

        absences = (List<Absence>) repo.findAllByStatut_Initiale();

        for (Absence a : absences ){
            if (a instanceof AbsenceObligatoire){
                a.setStatut(StatutType.VALIDEE);
                repo.save(a);
            }
        }
    }

}
