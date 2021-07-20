package fr.diginamic.projet.Service;

import fr.diginamic.projet.Entity.*;
import fr.diginamic.projet.Entity.Enumeration.StatutType;
import fr.diginamic.projet.Exception.AbsenceException;
import fr.diginamic.projet.Repository.AbsenceRepository;
import fr.diginamic.projet.Utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NightBatchService {
    @Autowired
    private AbsenceRepository repo;

    private final String CONGE_SANS_SOLDE = "CongeSansSolde";
    private final String CONGE_PAYE = "CongePaye";
    private final String RTT_EMPLOYE = "RttEmploye";
    private final String RTT_EMPLOYEUR = "RttEmployeur";
    private final String JOUR_FERIE = "JourFerie";


    public void traiterAbsenceChoisie() throws AbsenceException {
        repo.findAllByStatut(StatutType.INITIALE).forEach( absence -> {
                    switch (absence.getClass().getSimpleName()) {

                        case CONGE_SANS_SOLDE:
                            absence.setStatut(StatutType.EN_ATTENTE_VALIDATION);
                            repo.save(absence);
                            break;

                        case CONGE_PAYE:
                        case RTT_EMPLOYE:
                            AbsenceChoisie a = (AbsenceChoisie) absence;
                            if (a.getSalarie().getSoldeCP() < DateUtils.workedDaysBetween(a.getDateDebut(), a.getDateFin())) {
                                //pas suffisament de jours disponibles
                                absence.setStatut(StatutType.REJETEE);
                            } else { //validation ok
                                absence.setStatut(StatutType.EN_ATTENTE_VALIDATION);
                                if (absence.getSalarie().getManager() != null){
                                    sendMail(absence.getSalarie().getManager().getEmail());
                                }
                            }
                            repo.save(absence);
                            break;

                        default: //nothing to do
                    }
                });
    }

    public void traiterAbsenceObligatoire() {
        repo.findAllByStatut(StatutType.INITIALE).stream()
                .filter(absence -> absence.getClass().getSimpleName().equals(JOUR_FERIE) ||
                                        absence.getClass().getSimpleName().equals(RTT_EMPLOYEUR))
                .forEach(absence -> {
                    absence.setStatut(StatutType.VALIDEE);
                    repo.save(absence);
                });
    }

    private void sendMail(String email){
        //TODO envoi de mail
    }

}
