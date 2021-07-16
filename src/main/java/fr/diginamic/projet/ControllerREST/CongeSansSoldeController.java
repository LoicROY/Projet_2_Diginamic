package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Entity.CongeSansSolde;
import fr.diginamic.projet.Entity.Enumeration.StatutType;
import fr.diginamic.projet.Exception.AlgorithmException;
import fr.diginamic.projet.Service.CongeSansSoldeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/congeSansSolde")
public class CongeSansSoldeController {

    @Autowired
    CongeSansSoldeService congeSansSoldeService;

    @GetMapping("")
    public List<CongeSansSolde> getAll() {
        return congeSansSoldeService.findAll();
    }

    @GetMapping("/{id}")
    public CongeSansSolde get(@PathVariable("id") Long id) {
        return congeSansSoldeService.findById(id);
    }

    @PostMapping("/create")
    public CongeSansSolde create(@RequestBody CongeSansSolde congeSansSolde) throws AlgorithmException {
        if (congeSansSolde.getId() != null){
            throw new AlgorithmException("id != null ! Vous allez modifier au lieu de créer");
        }
        congeSansSolde.setStatut(StatutType.INITIALE);
        return congeSansSoldeService.save(congeSansSolde);
    }

    @PutMapping("/update")
    public CongeSansSolde update(@RequestBody CongeSansSolde congeSansSolde) throws AlgorithmException {
        if (congeSansSolde.getId() == null){
            throw new AlgorithmException("id = null ! Vous allez créer au lieu de modifier");
        }
        return congeSansSoldeService.save(congeSansSolde);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody CongeSansSolde congePaye) {
        congeSansSoldeService.delete(congePaye);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        congeSansSoldeService.delete(id);
    }
}