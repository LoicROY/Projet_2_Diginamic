package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Entity.RttEmployeur;
import fr.diginamic.projet.Entity.Enumeration.StatutType;
import fr.diginamic.projet.Exception.AlgorithmException;
import fr.diginamic.projet.Service.RttEmployeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rttEmployeur")
public class RttEmployeurController {

    @Autowired
    RttEmployeurService rttEmployeurService;

    @GetMapping("")
    public List<RttEmployeur> getAll() {
        return rttEmployeurService.findAll();
    }

    @GetMapping("/{id}")
    public RttEmployeur get(@PathVariable("id") Long id) {
        return rttEmployeurService.findById(id);
    }

    @PostMapping("/create")
    public RttEmployeur create(@RequestBody RttEmployeur rttEmployeur) throws AlgorithmException {
        if (rttEmployeur.getId() != null){
            throw new AlgorithmException("id != null ! Vous allez modifier au lieu de créer");
        }
        rttEmployeur.setStatut(StatutType.INITIALE);
        return rttEmployeurService.save(rttEmployeur);
    }

    @PutMapping("/update")
    public RttEmployeur update(@RequestBody RttEmployeur rttEmployeur) throws AlgorithmException {
        if (rttEmployeur.getId() == null){
            throw new AlgorithmException("id = null ! Vous allez créer au lieu de modifier");
        }
        return rttEmployeurService.save(rttEmployeur);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody RttEmployeur rttEmployeur) {
        rttEmployeurService.delete(rttEmployeur);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        rttEmployeurService.delete(id);
    }
}