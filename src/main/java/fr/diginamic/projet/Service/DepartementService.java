package fr.diginamic.projet.Service;

import fr.diginamic.projet.Entity.Departement;
import fr.diginamic.projet.Repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class DepartementService {
    @Autowired
    DepartementRepository repo;

    public List<Departement> list() {
        return (List<Departement>)repo.findAll();
    }

    public Departement get(Long id){
        Optional<Departement> opt= repo.findById(id);

        return opt.orElseThrow();


    }

    public Departement save(Departement departement){
        return repo.save(departement);
    }


    public void delete(Long id){
        repo.deleteById(id);
    }
    public void deleteManager (Departement departement){
        repo.delete(departement);
    }

}
