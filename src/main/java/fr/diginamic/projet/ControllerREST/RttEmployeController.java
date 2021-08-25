package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Entity.RttEmploye;
import fr.diginamic.projet.Entity.Enumeration.StatutType;
import fr.diginamic.projet.Entity.Salarie;
import fr.diginamic.projet.Exception.AbsenceException;
import fr.diginamic.projet.Exception.AlgorithmException;
import fr.diginamic.projet.Service.RttEmployeService;
import fr.diginamic.projet.Validator.AbsenceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/RttEmploye")
public class RttEmployeController {

    @Autowired
    private RttEmployeService rttEmployeService;

    @GetMapping("")
    public List<RttEmploye> getAll() {
        return rttEmployeService.findAll();
    }

    @GetMapping("/{id}")
    public RttEmploye get(@PathVariable("id") Long id) {
        return rttEmployeService.findById(id);
    }

    @PostMapping("")
    public RttEmploye create(@RequestBody RttEmploye rttEmploye) throws AlgorithmException, AbsenceException {
        if (rttEmploye.getId() != null){
            throw new AlgorithmException("id != null ! Vous allez modifier au lieu de créer");
        }
        AbsenceValidator.isValid(rttEmploye);
        rttEmploye.setStatut(StatutType.EN_ATTENTE_VALIDATION);
        Salarie userCurrent = (Salarie) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userCurrent.setAbsences(new HashSet<>());
        rttEmploye.setSalarie(userCurrent);
        return rttEmployeService.save(rttEmploye);
    }

    @PutMapping("")
    public RttEmploye update(@RequestBody RttEmploye rttEmploye) throws AlgorithmException, AbsenceException {
        if (rttEmploye.getId() == null){
            throw new AlgorithmException("id = null ! Vous allez créer au lieu de modifier");
        }
        AbsenceValidator.isValid(rttEmploye);
        return rttEmployeService.save(rttEmploye);
    }

    @DeleteMapping("")
    public void delete(@RequestBody RttEmploye rttEmploye) {
        rttEmployeService.delete(rttEmploye);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        rttEmployeService.delete(id);
    }
}