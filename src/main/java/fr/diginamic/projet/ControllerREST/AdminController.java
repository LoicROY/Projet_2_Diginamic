package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Entity.Administrateur;
import fr.diginamic.projet.Entity.Manager;
import fr.diginamic.projet.Service.AdminService;
import fr.diginamic.projet.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminService service;

    @GetMapping("/administrateur")
    public String listAdmin(Model model){
        List<Administrateur> list = service.list();
        model.addAttribute("admins", list);
        return "administrateur";
    }

    @GetMapping("/administrateur/create/{admins}")
    public String createAdmin(@PathVariable("admins")Long id, Model model)throws Exception{
        Administrateur administrateur= null;
        if(id==0L){
            //salarie = new Salarie(0l,"","","",);??????
        }else{
            administrateur = service.get(id);
        }
        model.addAttribute("admin",administrateur);
        return "createAdmins";
    }
    @PostMapping("/administrateur/create")
    public String PostCreateAdmin(Administrateur administrateur)throws Exception{

        service.save(administrateur);
        return "redirect:/administrateur";
    }
    @GetMapping("/administrateur/delete/{admins}")
    private String delete(@PathVariable("admins") long id)throws Exception{
        service.delete(id);
        return "redirect:/administrateur";
    }




}
