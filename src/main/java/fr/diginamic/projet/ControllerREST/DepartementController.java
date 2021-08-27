package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Entity.Departement;
import fr.diginamic.projet.Service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Departement")
public class DepartementController {

    @Autowired
    private DepartementService service;

    @GetMapping("/getAll")
    public List<Departement> listService(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Departement updateService(@PathVariable("id")Long id, Model model){
        return service.findById(id);
    }

    @PostMapping("")
    public Departement PostCreateDepartement(@RequestBody Departement departement){
        return service.save(departement);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") long id){
        service.delete(id);

    }

}
