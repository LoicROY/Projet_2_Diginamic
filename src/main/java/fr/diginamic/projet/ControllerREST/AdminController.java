package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Entity.Administrateur;
import fr.diginamic.projet.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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

    @GetMapping("/create/{id}")
    public Administrateur updateAdmin(@PathVariable("id")Long id){

        return service.findById(id);
    }
    @PostMapping("/create")
    public Administrateur PostCreateAdmin(@RequestBody Administrateur administrateur){

        administrateur = service.save(administrateur);

        return administrateur;
    }
    @GetMapping("/delete/{id}")
    private void delete(@PathVariable("id") long id){
        service.delete(id);

    }




}
