package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Entity.Administrateur;
import fr.diginamic.projet.Exception.AlgorithmException;
import fr.diginamic.projet.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/administrateur")
public class AdminController {

    @Autowired
    private AdminService service;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("")
    public List<Administrateur> listAdmin(){
        return service.findAll();
    }

    @PostMapping("")
    public Administrateur create(@RequestBody Administrateur administrateur) throws AlgorithmException {
        if (administrateur.getId() != null){
            throw new AlgorithmException("id != null ! Vous allez modifier au lieu de créer");
        }
        administrateur.setPassword(passwordEncoder.encode(administrateur.getPassword()));
        return service.save(administrateur);
    }

    @PutMapping("")
    public Administrateur update(@RequestBody Administrateur administrateur) throws AlgorithmException {
        if (administrateur.getId() == null){
            throw new AlgorithmException("id = null ! Vous allez créer au lieu de modifier");
        }
        administrateur.setPassword(passwordEncoder.encode(administrateur.getPassword()));
        return service.save(administrateur);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") long id){
        service.delete(id);
    }


}
