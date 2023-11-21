package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Questao;
import application.repository.QuestaoRepository;

@Controller
@RequestMapping("/Questao")
public class QuestaoController {
    @Autowired
    private QuestaoRepository questaoRepo;


@RequestMapping("/list")
public String list(Model ui) {
    ui.addAttribute("alunos", questaoRepo.findAll());
    return "/Questao/list";
}

@RequestMapping("/insert")
public String insert() {
    return "/Questao/insert";
}

@RequestMapping(value = "/insert", method = RequestMethod.POST)
public String insert(
    @RequestParam("Enunciado") String Enunciado) {
    Questao Questao = new Questao();
    Questao.setEnunciado(Enunciado);

    questaoRepo.save(Questao);

    return "redirect:/Questao/list";
}

@RequestMapping("/update")
public String update(
    @RequestParam("id") long id,
    Model ui
) {
    Optional<Questao> Questao = questaoRepo.findById((long) id);

    if(Questao.isPresent()) {
        ui.addAttribute("Questao", Questao.get());
        return "/Questao/update";
    }

    return "redirect:/Questao/list";
}

@RequestMapping(value = "/update", method = RequestMethod.POST)
public String update(
    @RequestParam("id") long id,
    @RequestParam("Enunciado") String Enunciado
) {
    Optional<Questao> resultado = questaoRepo.findById(id);

    if(resultado.isPresent()) {
        resultado.get().setEnunciado(Enunciado);
        

        questaoRepo.save(resultado.get());
    }

    return "redirect:/Questao/list";
}

@RequestMapping("/delete")
public String delete(
    @RequestParam("id") long id,
    Model ui
) {
    Optional<Questao> resultado = questaoRepo.findById((long) id);

    if(resultado.isPresent()) {
        ui.addAttribute("Questao", resultado.get());
        return "/Questao/delete";
    }

    return "redirect:/Questao/list";
}

@RequestMapping(value = "/delete", method = RequestMethod.POST)
public String delete(
    @RequestParam("id") long id
) {
    questaoRepo.deleteById(id);
    
    return "redirect:/Questao/list";
}
}
