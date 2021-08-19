package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Entity.CongePaye;
import fr.diginamic.projet.Entity.Enumeration.StatutType;
import fr.diginamic.projet.Exception.AbsenceException;
import fr.diginamic.projet.Exception.AlgorithmException;
import fr.diginamic.projet.Service.CongePayeService;
import fr.diginamic.projet.Validator.AbsenceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/congePaye")
public class CongePayeController {

    @Autowired
    private CongePayeService congePayeService;

    @GetMapping("")
    public List<CongePaye> getAll() {
        return congePayeService.findAll();
    }

    @GetMapping("/{id}")
    public CongePaye get(@PathVariable("id") Long id) {
        return congePayeService.findById(id);
    }

    @PostMapping("/create")
    public CongePaye create(@RequestBody CongePaye congePaye) throws AlgorithmException, AbsenceException {
        if (congePaye.getId() != null){
            throw new AlgorithmException("id != null ! Vous allez modifier au lieu de créer");
        }
        AbsenceValidator.isValid(congePaye);
        congePaye.setStatut(StatutType.INITIALE);
        return congePayeService.save(congePaye);
    }

    @PutMapping("/update")
    public CongePaye update(@RequestBody CongePaye congePaye) throws AlgorithmException, AbsenceException {
        if (congePaye.getId() == null){
            throw new AlgorithmException("id = null ! Vous allez créer au lieu de modifier");
        }
        AbsenceValidator.isValid(congePaye);
        return congePayeService.save(congePaye);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody CongePaye congePaye) {
        congePayeService.delete(congePaye);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        congePayeService.delete(id);
    }
}