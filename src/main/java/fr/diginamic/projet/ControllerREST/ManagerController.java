package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Entity.Manager;
import fr.diginamic.projet.Entity.Salarie;
import fr.diginamic.projet.Service.ManagerService;
import fr.diginamic.projet.Service.SalarieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagerController {
    @Autowired
    ManagerService service;

    @GetMapping("/manager")
    public String listManager(Model model){
        List<Manager> list = service.list();
        model.addAttribute("salaries", list);
        return "salarie";
    }

    @GetMapping("/manager/create/{managers}")
    public String createManager(@PathVariable("managers")Long id, Model model)throws Exception{
        Manager manager= null;
        if(id==0L){
            //salarie = new Salarie(0l,"","","",);??????
        }else{
            manager = service.get(id);
        }
        model.addAttribute("manager",manager);
        return "createManagers";
    }
    @PostMapping("/manager/create")
    public String PostCreateManager(Manager manager)throws Exception{

        service.save(manager);
        return "redirect:/manager";
    }
    @GetMapping("/manager/delete/{managers}")
    private String delete(@PathVariable("managers") long id)throws Exception{
        service.delete(id);
        return "redirect:/manager";
    }


}
