package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Entity.Manager;
import fr.diginamic.projet.Exception.AlgorithmException;
import fr.diginamic.projet.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService service;

    @GetMapping("")
    public List<Manager> listManager(){
        return service.findAll();
    }

    @PostMapping("/create")
    public Manager create(@RequestBody Manager manager) throws AlgorithmException {
        if (manager.getId() != null){
            throw new AlgorithmException("id != null ! Vous allez modifier au lieu de créer");
        }
        return service.save(manager);
    }

    @PutMapping("/update")
    public Manager update(@RequestBody Manager manager) throws AlgorithmException {
        if (manager.getId() == null){
            throw new AlgorithmException("id = null ! Vous allez créer au lieu de modifier");
        }
        return service.save(manager);
    }

    @GetMapping("/delete/{id}")
    private void delete(@PathVariable("id") long id)throws Exception{
        service.delete(id);

    }


}
