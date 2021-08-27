package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Entity.CongeAnticipe;
import fr.diginamic.projet.Entity.Enumeration.StatutType;
import fr.diginamic.projet.Entity.Salarie;
import fr.diginamic.projet.Exception.AbsenceException;
import fr.diginamic.projet.Exception.AlgorithmException;
import fr.diginamic.projet.Service.CongeAnticipeService;
import fr.diginamic.projet.Validator.AbsenceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/CongeAnticipe")
public class CongeAnticipeController {

    @Autowired
    private CongeAnticipeService congeAnticipeService;

    @GetMapping("")
    public List<CongeAnticipe> getAll() {
        return congeAnticipeService.findAll();
    }

    @GetMapping("/{id}")
    public CongeAnticipe get(@PathVariable("id") Long id) {
        return congeAnticipeService.findById(id);
    }

    @PostMapping("")
    public CongeAnticipe create(@RequestBody CongeAnticipe congeAnticipe) throws AlgorithmException, AbsenceException {
        if (congeAnticipe.getId() != null){
            throw new AlgorithmException("id != null ! Vous allez modifier au lieu de créer");
        }
        AbsenceValidator.isValid(congeAnticipe);
        congeAnticipe.setStatut(StatutType.INITIALE);
        Salarie userCurrent = (Salarie) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userCurrent.setAbsences(new HashSet<>());
        congeAnticipe.setSalarie(userCurrent);
        return congeAnticipeService.save(congeAnticipe);
    }

    @PutMapping("")
    public CongeAnticipe update(@RequestBody CongeAnticipe congeAnticipe) throws AlgorithmException, AbsenceException {
        if (congeAnticipe.getId() == null){
            throw new AlgorithmException("id = null ! Vous allez créer au lieu de modifier");
        }
        AbsenceValidator.isValid(congeAnticipe);
        return congeAnticipeService.save(congeAnticipe);
    }

    @DeleteMapping("")
    public void delete(@RequestBody CongeAnticipe congeAnticipe) {
        congeAnticipeService.delete(congeAnticipe);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        congeAnticipeService.delete(id);
    }
}