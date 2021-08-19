package fr.diginamic.projet.Repository;

import fr.diginamic.projet.Entity.Manager;
import org.springframework.data.repository.CrudRepository;

public interface ManagerRepository extends CrudRepository <Manager, Long> {
}
