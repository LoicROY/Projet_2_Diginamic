package fr.diginamic.projet.Repository;

import fr.diginamic.projet.Entity.Absence;
import fr.diginamic.projet.Entity.Enumeration.StatutType;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface AbsenceRepository extends CrudRepository<Absence, Long> {
   List<Absence> findAllByStatut(StatutType statutType);
}
