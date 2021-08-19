package fr.diginamic.projet.Repository;

import fr.diginamic.projet.Entity.Absence;
import fr.diginamic.projet.Entity.Salarie;
import org.springframework.data.repository.CrudRepository;

public interface SalarieRepository extends CrudRepository<Salarie, Long> {
    Salarie findByPrenomAndNom(String prenom,String nom);

}
