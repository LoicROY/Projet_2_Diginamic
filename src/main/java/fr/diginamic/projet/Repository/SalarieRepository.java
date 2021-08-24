package fr.diginamic.projet.Repository;

import fr.diginamic.projet.Entity.Salarie;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;


public interface SalarieRepository extends CrudRepository<Salarie, Long> {
    Salarie findByPrenomAndNom(String prenom,String nom);
    Optional<Salarie> findByEmail(String email);
}
