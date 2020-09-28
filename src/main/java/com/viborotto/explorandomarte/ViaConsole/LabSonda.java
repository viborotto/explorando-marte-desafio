package com.viborotto.explorandomarte.ViaConsole;

import java.util.Scanner;

public class LabSonda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String posicaoGiro;
        String vetor[] = {"W", "N", "E", "S"};
        int quantidadeDeSondasParaEnvio;

        System.out.println("Bem-vindx a estação espacial da Nasa, vamos começar nossa missão!\n" +
                            "################## MISSÃO EXPLORANDO MARTE ##################");
        System.out.println("Preparando sondas......");
        System.out.print("Defina a quantidade de sondas a serem enviadas: ");
        quantidadeDeSondasParaEnvio = sc.nextInt();
        System.out.println();

        Sonda sonda1 = new Sonda();

       for (int i = 1; i <= quantidadeDeSondasParaEnvio; i++){
            //pegar coordenadas x e y

           System.out.print("Nome da sonda: ");
           sonda1.setNome(sc.next());
           System.out.print("De as coordenadas X e Y da sonda, e a direcao: ");
           sonda1.setCoordenadaX(sc.nextInt());
           sonda1.setCoordenadaY(sc.nextInt());
           sonda1.setDirecao(sc.next());


           System.out.println(sonda1.getNome()+ " criada com sucesso em (" + sonda1.getCoordenadaX() + "," + sonda1.getCoordenadaY() + "), direcao " + sonda1.getDirecao());
           System.out.print("Instrucoes para sonda: ");
           sonda1.setInstrucoes(sc.next());

            //TODO INSTRUCOES;        R L muda a direcao  [W, N, E, S]      |       M muda x e y
           for (int j = 0; j < sonda1.getInstrucoes().length(); j++){
               int tamanho = sonda1.getInstrucoes().length();
               String step = sonda1.getInstrucoes().substring(j,j+1);
               if (step.equals("L")){
                   //TODO funcao que atualiza a direcao conforme o comando L
                   if (sonda1.getDirecao().equalsIgnoreCase("W")){
                       int indice = 0;
                       posicaoGiro = vetor[indice+3];
                       sonda1.setDirecao(posicaoGiro);
                   } else if (sonda1.getDirecao().equalsIgnoreCase("N")){
                       int indice = 1;
                       posicaoGiro = vetor[indice-1];
                       sonda1.setDirecao(posicaoGiro);
                   } else if (sonda1.getDirecao().equalsIgnoreCase("E")){
                       int indice = 2;
                       posicaoGiro = vetor[indice-1];
                       sonda1.setDirecao(posicaoGiro);
                   } else if (sonda1.getDirecao().equalsIgnoreCase("S")){
                       int indice = 3;
                       posicaoGiro = vetor[indice-1];
                       sonda1.setDirecao(posicaoGiro);
                   }
               } else if (step.equals("R")){
                   if (sonda1.getDirecao().equalsIgnoreCase("W")){
                        int indice = 0;
                        posicaoGiro = vetor[indice+1];
                        sonda1.setDirecao(posicaoGiro);
                   } else if (sonda1.getDirecao().equalsIgnoreCase("N")){
                        int indice = 1;
                        posicaoGiro = vetor[indice+1];
                        sonda1.setDirecao(posicaoGiro);
                   } else if (sonda1.getDirecao().equalsIgnoreCase("E")){
                        int indice = 2;
                        posicaoGiro = vetor[indice+1];
                        sonda1.setDirecao(posicaoGiro);
                   } else if (sonda1.getDirecao().equalsIgnoreCase("S")){
                        int indice = 3;
                        posicaoGiro = vetor[indice-3];
                        sonda1.setDirecao(posicaoGiro);
                   }
               } else if (step.equals("M")){
                   //caso a instrucao seja M
                   if (sonda1.getDirecao().equals("N")) {
                       sonda1.setCoordenadaY(sonda1.getCoordenadaY()+1);
                   } else if (sonda1.getDirecao().equals("S")) {
                       sonda1.setCoordenadaY(sonda1.getCoordenadaY()-1);
                   } else if (sonda1.getDirecao().equals("W")) {
                       sonda1.setCoordenadaX(sonda1.getCoordenadaX()-1);
                   } else {
                       sonda1.setCoordenadaX(sonda1.getCoordenadaX()+1);
                       String teste = sonda1.getCoordenadaX().toString();
                   }

               }
           }

           System.out.println("Exploracao finalizada em ("+ sonda1.getCoordenadaX() + "," + sonda1.getCoordenadaY() + "), direcao " + sonda1.getDirecao());

        }

        System.out.println("................... SONDAS IMPLANTADAS ...................\n" +
                "################## MISSÃO FINALIZADA ##################");


    }

//    public void mudandoDirecaoEsquerda(Sonda sonda){
//        // W N E S
//        // 0 1 2 3
//        String posicaoGiro;
//        String vetor[] = {"W", "N", "E", "S"};
//
//        if (sonda1.getDirecao().equalsIgnoreCase("W")){
//            int indice = 0;
//            posicaoGiro = vetor[indice+3];
//            sonda1.setDirecao(posicaoGiro);
//        } else if (sonda.getDirecao().equalsIgnoreCase("N")){
//            int indice = 1;
//            posicaoGiro = vetor[indice-1];
//            sonda.setDirecao(posicaoGiro);
//        } else if (sonda1.getDirecao().equalsIgnoreCase("E")){
//            int indice = 2;
//            posicaoGiro = vetor[indice-1];
//            sonda.setDirecao(posicaoGiro);
//        } else if (sonda1.getDirecao().equalsIgnoreCase("S")){
//            int indice = 3;
//            posicaoGiro = vetor[indice-1];
//            sonda.setDirecao(posicaoGiro);
//        }
//    }

//    public void mudandoDirecaoDireita(Sonda sonda){
//        // W N E S
//        // 0 1 2 3
//        String posicaoGiro;
//        String vetor[] = {"W", "N", "E", "S"};
//
//        if (sonda.getDirecao().equalsIgnoreCase("W")){
//            int indice = 0;
//            posicaoGiro = vetor[indice+1];
//            sonda.setDirecao(posicaoGiro);
//        } else if (sonda.getDirecao().equalsIgnoreCase("N")){
//            int indice = 1;
//            posicaoGiro = vetor[indice+1];
//            sonda.setDirecao(posicaoGiro);
//        } else if (sonda.getDirecao().equalsIgnoreCase("E")){
//            int indice = 2;
//            posicaoGiro = vetor[indice+1];
//            sonda.setDirecao(posicaoGiro);
//        } else if (sonda.getDirecao().equalsIgnoreCase("S")){
//            int indice = 3;
//            posicaoGiro = vetor[indice-3];
//            sonda.setDirecao(posicaoGiro);
//        }
//    }

}
