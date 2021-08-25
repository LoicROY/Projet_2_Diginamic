package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Entity.RttEmployeur;
import fr.diginamic.projet.Entity.Enumeration.StatutType;
import fr.diginamic.projet.Entity.Salarie;
import fr.diginamic.projet.Exception.AbsenceException;
import fr.diginamic.projet.Exception.AlgorithmException;
import fr.diginamic.projet.Service.RttEmployeurService;
import fr.diginamic.projet.Validator.AbsenceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/RttEmployeur")
public class RttEmployeurController {

    @Autowired
    private RttEmployeurService rttEmployeurService;

    @GetMapping("")
    public List<RttEmployeur> getAll() {
        return rttEmployeurService.findAll();
    }

    @GetMapping("/{id}")
    public RttEmployeur get(@PathVariable("id") Long id) {
        return rttEmployeurService.findById(id);
    }

    @PostMapping("")
    public RttEmployeur create(@RequestBody RttEmployeur rttEmployeur) throws AlgorithmException, AbsenceException {
        if (rttEmployeur.getId() != null){
            throw new AlgorithmException("id != null ! Vous allez modifier au lieu de créer");
        }
        AbsenceValidator.isValid(rttEmployeur);
        rttEmployeur.setStatut(StatutType.INITIALE);
        Salarie userCurrent = (Salarie) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userCurrent.setAbsences(new HashSet<>());
        rttEmployeur.setSalarie(userCurrent);
        return rttEmployeurService.save(rttEmployeur);
    }

    @PutMapping("")
    public RttEmployeur update(@RequestBody RttEmployeur rttEmployeur) throws AlgorithmException, AbsenceException {
        if (rttEmployeur.getId() == null){
            throw new AlgorithmException("id = null ! Vous allez créer au lieu de modifier");
        }
        AbsenceValidator.isValid(rttEmployeur);
        return rttEmployeurService.save(rttEmployeur);
    }

    @DeleteMapping("")
    public void delete(@RequestBody RttEmployeur rttEmployeur) {
        rttEmployeurService.delete(rttEmployeur);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        rttEmployeurService.delete(id);
    }
}