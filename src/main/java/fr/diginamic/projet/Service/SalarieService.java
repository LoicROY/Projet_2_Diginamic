package fr.diginamic.projet.Service;

import fr.diginamic.projet.Entity.Salarie;
import fr.diginamic.projet.Repository.SalarieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalarieService {
    @Autowired
    SalarieRepository repo;

    public List<Salarie> list() {
        return (List<Salarie>)repo.findAll();
    }

    public Salarie get(Long id){
        Optional<Salarie> opt= repo.findById(id);
        return opt.orElseThrow();
    }

    public Salarie save(Salarie salarie){
        return repo.save(salarie);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }

    public void deleteSalarie (Salarie salarie){
        repo.delete(salarie);
    }

}
