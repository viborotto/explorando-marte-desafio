package com.viborotto.explorandomarte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExplorandoMarteApplication {

    public static void main(String[] args) {
        System.out.println("Bem-vindx a estação espacial da Nasa, vamos começar nossa missão!\n" +
                "################## MISSÃO EXPLORANDO MARTE ##################");
        System.out.println("Preparando sondas......");

        SpringApplication.run(ExplorandoMarteApplication.class, args);

        System.out.println("................... SONDAS IMPLANTADAS ...................\n" +
                "################## MISSÃO FINALIZADA ##################");
        System.out.println("\n");


    }

}
