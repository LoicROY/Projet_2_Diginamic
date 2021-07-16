package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Entity.JourFerie;
import fr.diginamic.projet.Entity.Enumeration.StatutType;
import fr.diginamic.projet.Exception.AlgorithmException;
import fr.diginamic.projet.Service.JourFerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jourFerie")
public class JourFerieController {

    @Autowired
    JourFerieService jourFerieService;

    @GetMapping("")
    public List<JourFerie> getAll() {
        return jourFerieService.findAll();
    }

    @GetMapping("/{id}")
    public JourFerie get(@PathVariable("id") Long id) {
        return jourFerieService.findById(id);
    }

    @PostMapping("/create")
    public JourFerie create(@RequestBody JourFerie jourFerie) throws AlgorithmException {
        if (jourFerie.getId() != null){
            throw new AlgorithmException("id != null ! Vous allez modifier au lieu de créer");
        }
        jourFerie.setStatut(StatutType.INITIALE);
        return jourFerieService.save(jourFerie);
    }

    @PutMapping("/update")
    public JourFerie update(@RequestBody JourFerie jourFerie) throws AlgorithmException {
        if (jourFerie.getId() == null){
            throw new AlgorithmException("id = null ! Vous allez créer au lieu de modifier");
        }
        return jourFerieService.save(jourFerie);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody JourFerie jourFerie) {
        jourFerieService.delete(jourFerie);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        jourFerieService.delete(id);
    }
}