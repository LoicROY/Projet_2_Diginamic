package fr.diginamic.projet.Service;

import fr.diginamic.projet.Entity.Administateur;
import fr.diginamic.projet.Entity.Manager;
import fr.diginamic.projet.Repository.AdminRepository;
import fr.diginamic.projet.Repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AdminService {
    @Autowired
    AdminRepository repo;

    public List<Administateur> list() {
        return (List<Administateur>)repo.findAll();
    }

    public Administateur get(Long id){
        Optional<Administateur> opt= repo.findById(id);

        return opt.orElseThrow();


    }

    public Administateur save(Administateur administateur){
        return repo.save(administateur);
    }


    public void delete(Long id){
        repo.deleteById(id);
    }
    public void deleteAdmin (Administateur administateur){
        repo.delete(administateur);
    }
}
