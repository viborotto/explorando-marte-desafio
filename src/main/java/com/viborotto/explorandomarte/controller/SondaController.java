package com.viborotto.explorandomarte.controller;

import com.viborotto.explorandomarte.model.Sonda;
import com.viborotto.explorandomarte.service.SondaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Sondas Endpoints")
@Controller
public class SondaController {

    @Autowired
    private SondaService sondaService;

    //todo precisa de id? DTO? descricao da sonda ao retornar o objeto no post e na listagem
    @ApiOperation(value = "Criar uma Sonda e enviar pra Marte" )
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method=RequestMethod.POST, value="/novaSonda")
    public String criarSonda(@RequestBody Sonda sonda, Model model){
        sondaService.criarSonda(sonda);
        model.addAttribute("sondas", sondaService.listarSondas());
        return "redirect:/index";
    }

    @ApiOperation(value = "Listar sondas em Marte" )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method=RequestMethod.GET, value="/api/v1/sondas")
    public String listarSonda(Model model){
        List<Sonda> listaSondas = sondaService.listarSondas();

        model.addAttribute("listaSondas", listaSondas);
        return "index";
    }
}
