package fr.diginamic.projet.Service;

import fr.diginamic.projet.Entity.*;
import fr.diginamic.projet.Entity.Enumeration.StatutType;
import fr.diginamic.projet.Exception.AbsenceException;
import fr.diginamic.projet.Repository.AbsenceRepository;
import fr.diginamic.projet.Utils.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class NightBatchService {
    protected final Log logger = LogFactory.getLog(this.getClass());
    @Autowired
    AbsenceRepository repo;


    public void traiterAbsenceChoisie() throws AbsenceException {


      List<Absence>absences =  repo.findAllByStatut(StatutType.INITIALE);

      for (Absence a : absences ){

          if (a instanceof AbsenceChoisie){
        	  String typeConge = a.getClass().getSimpleName();
        	  switch(typeConge) {
        	  	case "CongeSansSolde" :
        	  		a.setStatut(StatutType.EN_ATTENTE_VALIDATION);
                    repo.save(a);
        	  		break;
        	  	case "RttEmploye" :
        	  		if ((RttEmploye.NOMBRE_MAX - a.getSalarie().getSoldeRTT()) + DateUtils.interval(a) <= RttEmploye.NOMBRE_MAX){
                        a.setStatut(StatutType.EN_ATTENTE_VALIDATION);
                        repo.save(a);
                    }else{
                        a.setStatut(StatutType.REJETEE);
                        repo.save(a);
                    }
        	  		break;
        	  	case "CongePaye" :
        	  		if ((CongePaye.NOMBRE_MAX - a.getSalarie().getSoldeCP()) + DateUtils.interval(a) <= CongePaye.NOMBRE_MAX){
                        a.setStatut(StatutType.EN_ATTENTE_VALIDATION);
                        repo.save(a);
                    }else{
                        a.setStatut(StatutType.REJETEE);
                        repo.save(a);
                    }
        	  		break;
        	  		
        	  }
//              if (a instanceof CongeSansSolde){
//                  a.setStatut(StatutType.EN_ATTENTE_VALIDATION);
//                  repo.save(a);
//              }
//              else if (a instanceof RttEmploye){
//                  if ((RttEmploye.NOMBRE_MAX - a.getSalarie().getSoldeRTT()) + DateUtils.interval(a) <= RttEmploye.NOMBRE_MAX){
//                      a.setStatut(StatutType.EN_ATTENTE_VALIDATION);
//                      repo.save(a);
//                  }else{
//                      a.setStatut(StatutType.REJETEE);
//                      repo.save(a);
//                  }
//              }
//              else if (a instanceof CongePaye) {
//
//                  if ((CongePaye.NOMBRE_MAX - a.getSalarie().getSoldeCP()) + DateUtils.interval(a) <= CongePaye.NOMBRE_MAX){
//                      a.setStatut(StatutType.EN_ATTENTE_VALIDATION);
//                      repo.save(a);
//                  }else{
//                      a.setStatut(StatutType.REJETEE);
//                      repo.save(a);
//                  }
//              }
          }
      }
    }

    public void traiterAbsenceObligatoire(){

        List<Absence>absences=  repo.findAllByStatut(StatutType.INITIALE);

        for (Absence a : absences ){
            if (a instanceof AbsenceObligatoire){
                a.setStatut(StatutType.VALIDEE);
                repo.save(a);
            }
        }
    }

}
