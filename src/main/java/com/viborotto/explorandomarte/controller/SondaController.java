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

    //TODO demais retornos da api e Exceptions
    //TODO arrumar redirect Thymeleaf
    /**
     * Endpoints MVC - integrados com Thymeleaf
     * Tendo em vista padrao REST em seus 3 niveis, essa aplicacao esta no nivel 2 REST
     */
    @ApiOperation(value = "Criar uma Sonda e enviar pra Marte" )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/savedSonda")
    public String saveSonda(@ModelAttribute("sonda") Sonda sonda) {
        // save employee to database
        sondaService.criarSonda(sonda);
        return "redirect:/api/v1/sondas";
    }

    @ApiOperation(value = "Listar sondas em Marte" )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method=RequestMethod.GET, value="/api/v1/sondas")
    public String listarSonda(Model model){
        List<Sonda> listaSondas = sondaService.listarSondas();
        Sonda sonda = new Sonda();

        model.addAttribute("sonda", sonda);
        model.addAttribute("listaSondas", listaSondas);
        return "index";
    }

    @ApiOperation(value = "Retornar sonda para Terra" )
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/deleteSonda/{id}")
    public String deleteSonda(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.sondaService.deletarSonda(id);
        return "redirect:/api/v1/sondas";
    }


    /**
     * Caso nao queira acessar o servico no browser via Thymeleaf
     * Aqui se encontram alguns endpoints para utilizacao do Postman
     */
    @ApiOperation(value = "POSTMAN - Criar uma Sonda e enviar pra Marte" )
    @PostMapping("/salvarSonda")
    public ResponseEntity salvarSondaPostman(@RequestBody Sonda sonda) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sondaService.criarSonda(sonda));
    }

    @ApiOperation(value = "POSTMAN - Listar sondas em Marte" )
    @GetMapping("/sondas")
    public ResponseEntity<?> listarSondaPostman(){
        return ResponseEntity.status(HttpStatus.OK).body(sondaService.listarSondas());
    }

    @ApiOperation(value = "POSTMAN - Listar sondas em Marte" )
    @GetMapping("/sondas/{id}")
    public ResponseEntity<?> listarSondaPostman(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(sondaService.getSonda(id));
    }

    @ApiOperation(value = "POSTMAN - Retornar sonda para Terra" )
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/deletarSonda/{id}")
    public void deletarSondaPostman(@PathVariable Long id) {
        this.sondaService.deletarSonda(id);
    }
}
