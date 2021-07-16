package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Entity.Salarie;
import fr.diginamic.projet.Service.SalarieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalarieController {
    @Autowired
    SalarieService service;

    @GetMapping("/salarie")
    public List<Salarie> listSalarie(){

        return service.list();
    }

    @GetMapping("/salarie/create/{id}")
    public Salarie updateSalarie(@PathVariable("id")Long id, Model model)throws Exception{

        return service.get(id);
    }
    @PostMapping("/salarie/create")
    public Salarie PostCreateSalarie(@RequestBody Salarie salarie)throws Exception{

        salarie = service.save(salarie);

        return salarie;
    }
    @GetMapping("/salarie/delete/{id}")
    private void delete(@PathVariable("id") long id)throws Exception{
        service.delete(id);

    }

}
