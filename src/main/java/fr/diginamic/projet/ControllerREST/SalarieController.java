package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Entity.CongePaye;
import fr.diginamic.projet.Entity.Salarie;
import fr.diginamic.projet.Service.SalarieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salarie")
public class SalarieController {

    @Autowired
    SalarieService salarieService;

    @GetMapping("test")
    public String test() {
        return "test ok";
    }

    @GetMapping("")
    public List<Salarie> getAll() {
        return salarieService.findAll();
    }

}
