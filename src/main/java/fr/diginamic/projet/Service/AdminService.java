package fr.diginamic.projet.Service;

import fr.diginamic.projet.Entity.Administrateur;
import fr.diginamic.projet.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AdminService {
    @Autowired
    AdminRepository repo;

    public List<Administrateur> list() {
        return (List<Administrateur>)repo.findAll();
    }

    public Administrateur get(Long id){
        Optional<Administrateur> opt= repo.findById(id);
        return opt.orElseThrow();
    }

    public Administrateur save(Administrateur administrateur){
        return repo.save(administrateur);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }

    public void deleteAdmin (Administrateur administrateur){
        repo.delete(administrateur);
    }
}