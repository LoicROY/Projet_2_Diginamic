package fr.diginamic.projet.Repository;

import fr.diginamic.projet.Entity.Administateur;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Administateur, Long> {
}
