package fr.diginamic.projet.Service;

import fr.diginamic.projet.Entity.Administrateur;
import fr.diginamic.projet.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AdminService extends CrudService<Administrateur> {

}
