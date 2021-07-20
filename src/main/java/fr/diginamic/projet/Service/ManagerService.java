package fr.diginamic.projet.Service;

import fr.diginamic.projet.Entity.Absence;
import fr.diginamic.projet.Entity.Enumeration.StatutType;
import fr.diginamic.projet.Entity.Manager;
import fr.diginamic.projet.Entity.Salarie;
import fr.diginamic.projet.Repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    @Autowired
    ManagerRepository repo;

    public List<Manager> list() {
        return (List<Manager>)repo.findAll();
    }

    public Manager get(Long id){
        Optional<Manager> opt= repo.findById(id);

        return opt.orElseThrow();


    }

    public Manager save(Manager manager){
        return repo.save(manager);
    }


    public void delete(Long id){
        repo.deleteById(id);
    }
    public void deleteManager (Manager manager){
        repo.delete(manager);
    }


}
