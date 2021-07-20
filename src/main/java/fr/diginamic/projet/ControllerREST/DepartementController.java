package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Entity.Departement;
import fr.diginamic.projet.Service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/departement")
public class DepartementController {

    @Autowired
    DepartementService service;

    @GetMapping("")
    public List<Departement> listService(){

        return service.findAll();
    }

    @GetMapping("/create/{id}")
    public Departement updateService(@PathVariable("id")Long id, Model model)throws Exception{

        return service.findById(id);
    }
    @PostMapping("/create")
    public Departement PostCreateDepartement(@RequestBody Departement departement)throws Exception{

        departement = service.save(departement);

        return departement;
    }
    @GetMapping("/delete/{id}")
    private void delete(@PathVariable("id") long id)throws Exception{
        service.delete(id);

    }

}
