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
    SalarieService service;

    @GetMapping("")
    public List<Salarie> listSalarie(){
        return service.list();
    }

    @GetMapping("/create/{id}")
    public Salarie updateSalarie(@PathVariable("id")Long id)throws Exception{
        return service.get(id);
    }
    @PostMapping("/create")
    public Salarie PostCreateSalarie(@RequestBody Salarie salarie)throws Exception{
        salarie = service.save(salarie);
        return salarie;
    }
    @GetMapping("/delete/{id}")
    private void delete(@PathVariable("id") long id)throws Exception{
        service.delete(id);
    }

}
