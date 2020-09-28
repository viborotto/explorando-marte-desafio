package com.viborotto.explorandomarte.controller;

import com.viborotto.explorandomarte.model.Sonda;
import com.viborotto.explorandomarte.service.SondaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class SondaController {

    @Autowired
    private SondaService sondaService;

    @PostMapping("/sonda/{id}")
    public ResponseEntity<?> criarSonda(@RequestBody Sonda sonda, @PathVariable int id){
        return ResponseEntity.status(HttpStatus.CREATED).body(sondaService.criarSonda(sonda, id));
    }

    @GetMapping("/sondas")
    public ResponseEntity<?> listarSonda(){
        return ResponseEntity.status(HttpStatus.OK).body(sondaService.listarSondas());
    }
}
