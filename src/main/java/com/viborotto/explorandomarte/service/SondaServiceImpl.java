package com.viborotto.explorandomarte.service;

import com.viborotto.explorandomarte.exception.LimiteUltrapassadoException;
import com.viborotto.explorandomarte.model.Sonda;
import com.viborotto.explorandomarte.repository.SondaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SondaServiceImpl implements SondaService{

    private final String vetor[] = {"W", "N", "E", "S"};

    @Autowired
    private SondaRepository sondaRepository;

    @Override
    public Sonda criarSonda(Sonda sonda) throws RuntimeException{

            for (int j = 0; j < sonda.getInstrucoes().length(); j++){
                String step = sonda.getInstrucoes().substring(j,j+1);

                if (step.equals("L")){
                    giraParaEsquerda(sonda, vetor);
                } else if (step.equals("R")){
                    giraParaDireita(sonda, vetor);
                } else if (step.equals("M")){
                    andaParaFrente(sonda);

                }
            }
            if(!(sonda.getCoordenadaX()>sonda.getTamanhoSuperficieX()||sonda.getCoordenadaY()>sonda.getTamanhoSuperficieY())){
                System.out.println("Exploracao finalizada da sonda " + sonda.getNome() + " em (" + sonda.getCoordenadaX() + "," + sonda.getCoordenadaY() + "), direcao " + sonda.getDirecao());
                return sondaRepository.save(sonda);
            }
            throw new LimiteUltrapassadoException();
    }

    @Override
    public Sonda getSonda(Long id) {
        Optional<Sonda> optionalSonda = sondaRepository.findById(id);
        return optionalSonda.get();
    }

    @Override
    public List<Sonda> listarSondas() {
        return (List<Sonda>) sondaRepository.findAll();
    }

    @Override
    public void deletarSonda(Long id) {
        this.sondaRepository.deleteById(id);
    }

        public void giraParaEsquerda(Sonda sonda, String vetor[]){
        // W N E S
        // 0 1 2 3
        String posicaoGiro;

        if (sonda.getDirecao().equalsIgnoreCase("W")){
            int indice = 0;
            posicaoGiro = vetor[indice+3];
            sonda.setDirecao(posicaoGiro);
        } else if (sonda.getDirecao().equalsIgnoreCase("N")){
            int indice = 1;
            posicaoGiro = vetor[indice-1];
            sonda.setDirecao(posicaoGiro);
        } else if (sonda.getDirecao().equalsIgnoreCase("E")){
            int indice = 2;
            posicaoGiro = vetor[indice-1];
            sonda.setDirecao(posicaoGiro);
        } else if (sonda.getDirecao().equalsIgnoreCase("S")){
            int indice = 3;
            posicaoGiro = vetor[indice-1];
            sonda.setDirecao(posicaoGiro);
        }
    }
    public void giraParaDireita(Sonda sonda, String vetor[]){
        // W N E S
        // 0 1 2 3
        String posicaoGiro;

        if (sonda.getDirecao().equalsIgnoreCase("W")){
            int indice = 0;
            posicaoGiro = vetor[indice+1];
            sonda.setDirecao(posicaoGiro);
        } else if (sonda.getDirecao().equalsIgnoreCase("N")){
            int indice = 1;
            posicaoGiro = vetor[indice+1];
            sonda.setDirecao(posicaoGiro);
        } else if (sonda.getDirecao().equalsIgnoreCase("E")){
            int indice = 2;
            posicaoGiro = vetor[indice+1];
            sonda.setDirecao(posicaoGiro);
        } else if (sonda.getDirecao().equalsIgnoreCase("S")){
            int indice = 3;
            posicaoGiro = vetor[indice-3];
            sonda.setDirecao(posicaoGiro);
        }
    }
    public void andaParaFrente(Sonda sonda){
        // W N E S
        // 0 1 2 3
        if (sonda.getDirecao().equals("N")) {
            sonda.setCoordenadaY(sonda.getCoordenadaY()+1);
        } else if (sonda.getDirecao().equals("S")) {
            sonda.setCoordenadaY(sonda.getCoordenadaY()-1);
        } else if (sonda.getDirecao().equals("W")) {
            sonda.setCoordenadaX(sonda.getCoordenadaX()-1);
        } else {
            sonda.setCoordenadaX(sonda.getCoordenadaX()+1);
        }
    }

}
