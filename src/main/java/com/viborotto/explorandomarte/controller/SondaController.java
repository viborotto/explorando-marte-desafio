package com.viborotto.explorandomarte.controller;

import com.viborotto.explorandomarte.model.Sonda;
import com.viborotto.explorandomarte.service.SondaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Sondas Endpoints")
@Controller
public class SondaController {

    @Autowired
    private SondaService sondaService;

    //todo DTO? descricao da sonda ao retornar o objeto no post e na listagem
//    @ApiOperation(value = "Criar uma Sonda e enviar pra Marte" )
//    @ResponseStatus(HttpStatus.CREATED)
//    @RequestMapping(method=RequestMethod.POST, value={"/","/api/v1/addSondas"})
//    public String criarSonda(@ModelAttribute Sonda sonda, BindingResult bindingResult, Model model){
//        if (bindingResult.hasErrors()) {
//            System.out.println("There was a error "+bindingResult);
//        }
//        Sonda formSonda = new Sonda();
//        model.addAttribute("sonda", formSonda);
//        sondaService.criarSonda(formSonda);
//        return "index";
//    }

//    @GetMapping("/")
//    public String showNewSondaForm(Model model) {
//        // create model attribute to bind form data
//        Sonda sonda = new Sonda();
//        model.addAttribute("sonda", sonda);
//        return "index";
//    }

    @ApiOperation(value = "Criar uma Sonda e enviar pra Marte" )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public String saveSonda(@ModelAttribute("sonda") Sonda sonda) {
        // save employee to database
        sondaService.criarSonda(sonda);
        return "index";
    }

    @ApiOperation(value = "Listar sondas em Marte" )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method=RequestMethod.GET, value="/")
    public String listarSonda(Model model){
        List<Sonda> listaSondas = sondaService.listarSondas();
        Sonda sonda = new Sonda();

        model.addAttribute("sonda", sonda);
        model.addAttribute("listaSondas", listaSondas);
        return "index";
    }
}
