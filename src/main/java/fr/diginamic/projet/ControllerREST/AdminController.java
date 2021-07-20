package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Entity.Administrateur;
import fr.diginamic.projet.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminService service;

    @GetMapping("/administrateur")
    public List<Administrateur> listAdmin(){

        return service.findAll();
    }

    @GetMapping("/administrateur/create/{id}")
    public Administrateur updateAdmin(@PathVariable("id")Long id, Model model)throws Exception{

        return service.findById(id);
    }
    @PostMapping("/administrateur/create")
    public Administrateur PostCreateAdmin(@RequestBody Administrateur administrateur)throws Exception{

        administrateur = service.save(administrateur);

        return administrateur;
    }
    @GetMapping("/administrateur/delete/{id}")
    private void delete(@PathVariable("id") long id)throws Exception{
        service.delete(id);

    }




}
