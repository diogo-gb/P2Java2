package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Alternativa;
import application.repository.AlternativaRepository;

@Controller
@RequestMapping("/Questao")
public class AlternativaController {
    
    @Autowired
    private AlternativaRepository alternativaRepo;

    @RequestMapping("/list")
    public String list(Model ui) {
        ui.addAttribute("alternativa", alternativaRepo.findAll());
        return "/Alternativa/list";
    }
    
    @RequestMapping("/insert")
    public String insert() {
        return "/Alternativa/insert";
    }
    
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(
        @RequestParam("Texto") String Texto) {
        Alternativa Alternativa = new Alternativa();
        Alternativa.setTexto(Texto);
    
        alternativaRepo.save(Alternativa);
    
        return "redirect:/Alternativa/list";
    }
    
    @RequestMapping("/update")
    public String update(
        @RequestParam("id") long id,
        Model ui
    ) {
        Optional<Alternativa> Alternativa = alternativaRepo.findById((long) id);
    
        if(Alternativa.isPresent()) {
            ui.addAttribute("Alternativa", Alternativa.get());
            return "/Alternativa/update";
        }
    
        return "redirect:/Alternativa/list";
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
        @RequestParam("id") long id,
        @RequestParam("Texto") String Texto
    ) {
        Optional<Alternativa> resultado = alternativaRepo.findById(id);
    
        if(resultado.isPresent()) {
            resultado.get().setTexto(Texto);
            
    
            alternativaRepo.save(resultado.get());
        }
    
        return "redirect:/Alternativa/list";
    }
    
    @RequestMapping("/delete")
    public String delete(
        @RequestParam("id") long id,
        Model ui
    ) {
        Optional<Alternativa> resultado = alternativaRepo.findById((long) id);
    
        if(resultado.isPresent()) {
            ui.addAttribute("Alternativa", resultado.get());
            return "/Alternativa/delete";
        }
    
        return "redirect:/Alternativa/list";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(
        @RequestParam("id") long id
    ) {
        alternativaRepo.deleteById(id);
        
        return "redirect:/Alternativa/list";
    }
}
