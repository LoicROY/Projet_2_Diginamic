package fr.diginamic.projet.Repository;

import fr.diginamic.projet.Entity.Absence;
import org.springframework.data.repository.CrudRepository;

public interface AbsenceRepository extends CrudRepository<Absence, Long> {



    Absence findAllByStatut_Initiale();

}
