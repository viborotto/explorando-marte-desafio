package com.viborotto.explorandomarte.service;

import com.viborotto.explorandomarte.model.Sonda;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SondaService {

    List<Sonda> listarSondas();

    Sonda criarSonda(Sonda sonda, int quantidadeDeSondasParaEnvio);

//    Sonda getSonda(Long id);
//    Sonda atualizarSonda(Long id, Sonda banda);
//    void deletarSonda(Long id);

}
