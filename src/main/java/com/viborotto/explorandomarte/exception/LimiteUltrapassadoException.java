package com.viborotto.explorandomarte.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LimiteUltrapassadoException extends RuntimeException{

    public LimiteUltrapassadoException() {
        super("Limite da superficie a ser explorada foi ultrapassado, tente novamente");
    }
}
