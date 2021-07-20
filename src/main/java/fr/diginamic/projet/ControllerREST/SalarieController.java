package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Entity.Salarie;
import fr.diginamic.projet.Service.SalarieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salarie")
public class SalarieController {

    @Autowired
    private SalarieService service;

    @GetMapping("")
    public List<Salarie> listSalarie(){
        return service.findAll();
    }

    @GetMapping("/create/{id}")
    public Salarie updateSalarie(@PathVariable("id")Long id){
        return service.findById(id);
    }
    @PostMapping("/create")
    public Salarie PostCreateSalarie(@RequestBody Salarie salarie){
        salarie = service.save(salarie);
        return salarie;
    }
    @GetMapping("/delete/{id}")
    private void delete(@PathVariable("id") long id){
        service.delete(id);
    }

}
