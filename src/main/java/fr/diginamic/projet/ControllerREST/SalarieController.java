package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Entity.Salarie;
import fr.diginamic.projet.Exception.AlgorithmException;
import fr.diginamic.projet.Service.SalarieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Salarie")
public class SalarieController {

    @Autowired
    private SalarieService service;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("")
    public List<Salarie> listSalarie(){
        return service.findAll();
    }

    @PostMapping("")
    public Salarie create(@RequestBody Salarie salarie) throws AlgorithmException {
        if (salarie.getId() != null){
            throw new AlgorithmException("id != null ! Vous allez modifier au lieu de créer");
        }
        salarie.setPassword(passwordEncoder.encode(salarie.getPassword()));
        return service.save(salarie);
    }

    @PutMapping("")
    public Salarie update(@RequestBody Salarie salarie) throws AlgorithmException {
        if (salarie.getId() == null){
            throw new AlgorithmException("id = null ! Vous allez créer au lieu de modifier");
        }
        salarie.setPassword(passwordEncoder.encode(salarie.getPassword()));
        return service.save(salarie);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") long id){
        service.delete(id);
    }

}
