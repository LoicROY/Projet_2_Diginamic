package fr.diginamic.projet.Repository;

import fr.diginamic.projet.Entity.Departement;
import org.springframework.data.repository.CrudRepository;

public interface DepartementRepository extends CrudRepository<Departement, Long> {
}
