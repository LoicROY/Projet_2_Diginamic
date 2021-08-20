package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Entity.Manager;
import fr.diginamic.projet.Exception.AlgorithmException;
import fr.diginamic.projet.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService service;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("")
    public List<Manager> listManager(){
        return service.findAll();
    }

    @PostMapping("")
    public Manager create(@RequestBody Manager manager) throws AlgorithmException {
        if (manager.getId() != null){
            throw new AlgorithmException("id != null ! Vous allez modifier au lieu de créer");
        }
        manager.setPassword(passwordEncoder.encode(manager.getPassword()));
        return service.save(manager);
    }

    @PutMapping("")
    public Manager update(@RequestBody Manager manager) throws AlgorithmException {
        if (manager.getId() == null){
            throw new AlgorithmException("id = null ! Vous allez créer au lieu de modifier");
        }
        manager.setPassword(passwordEncoder.encode(manager.getPassword()));
        return service.save(manager);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") long id){
        service.delete(id);
    }


}
