package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Entity.Administrateur;
import fr.diginamic.projet.Exception.AlgorithmException;
import fr.diginamic.projet.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/administrateur")
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping("")
    public List<Administrateur> listAdmin(){

        return service.findAll();
    }

    @PostMapping("/create")
    public Administrateur create(@RequestBody Administrateur administrateur) throws AlgorithmException {
        if (administrateur.getId() != null){
            throw new AlgorithmException("id != null ! Vous allez modifier au lieu de créer");
        }
        return service.save(administrateur);
    }

    @PutMapping("/update")
    public Administrateur update(@RequestBody Administrateur administrateur) throws AlgorithmException {
        if (administrateur.getId() == null){
            throw new AlgorithmException("id = null ! Vous allez créer au lieu de modifier");
        }
        return service.save(administrateur);
    }

    @GetMapping("/delete/{id}")
    private void delete(@PathVariable("id") long id){
        service.delete(id);

    }




}
