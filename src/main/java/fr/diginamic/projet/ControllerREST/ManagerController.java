package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Entity.Manager;
import fr.diginamic.projet.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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

    @GetMapping("/create/{id}")
    public Manager update(@PathVariable("id")Long id, Model model)throws Exception{
        return service.findById(id);
    }
    @PostMapping("/create")
    public Manager PostCreateManager(@RequestBody Manager manager)throws Exception{
        manager = service.save(manager);
        return manager;
    }
    @GetMapping("/delete/{id}")
    private void delete(@PathVariable("id") long id)throws Exception{
        service.delete(id);

    }


}
