package fr.diginamic.projet.ControllerREST;

import fr.diginamic.projet.Entity.Salarie;
import fr.diginamic.projet.Entity.Service;
import fr.diginamic.projet.Service.SalarieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class SalarieController {
   @Autowired
    SalarieService service;

   @GetMapping("/salarie")
    public List<Salarie> listSalarie(){

       return service.list();
   }

   @GetMapping("/salarie/create/{salaries}")
    public String createSalarie(@PathVariable("salaries")Long id,Model model)throws Exception{
       Salarie salarie= null;
       if(id==1L){
           salarie = new Salarie();
       }else{
           salarie = service.get(id);
       }
       model.addAttribute("salarie",salarie);
       return "createSalaries";
   }
   @PostMapping("/salarie/create")
    public String PostCreateSalarie(Salarie salarie)throws Exception{

           service.save(salarie);
       return "redirect:/salarie";
   }
    @GetMapping("/salarie/delete/{salaries}")
    private String delete(@PathVariable("salaries") long id)throws Exception{
        service.delete(id);
        return "redirect:/salarie";
    }

}
