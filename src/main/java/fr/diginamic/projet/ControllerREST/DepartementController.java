package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Entity.Departement;
import fr.diginamic.projet.Service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class DepartementController {

    @Autowired
    private DepartementService service;

    @GetMapping("/departement")
    public List<Departement> listService(){

        return service.list();
    }

    @GetMapping("/departement/create/{id}")
    public Departement updateService(@PathVariable("id")Long id, Model model)throws Exception{

        return service.get(id);
    }
    @PostMapping("/departement/create")
    public Departement PostCreateDepartement(@RequestBody Departement departement)throws Exception{

        departement = service.save(departement);

        return departement;
    }
    @GetMapping("/departement/delete/{id}")
    private void delete(@PathVariable("id") long id)throws Exception{
        service.delete(id);

    }

}
