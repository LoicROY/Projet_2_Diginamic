package fr.diginamic.projet.Repository;

import fr.diginamic.projet.Entity.Administrateur;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Administrateur, Long> {
}
