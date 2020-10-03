# Explorando Marte Desafio
Desafio em que a API cria Sondas para marte com suas coordenadas e movimentos

## Tecnologias utilizadas
   
   - Java 11
   - Spring Boot | Spring Data JPA
   - Profiles: MySQL ou H2 ou Docker-mysql
   - Thymeleaf
   - Documentado com Swagger: http://localhost:8080/swagger-ui.html
   - Docker
   - (Testes)
   - Nivel 2 de maturidade REST
   - Spring
   - JUnit

## Entendendo o Problema a ser Resolvido:

Um conjunto de sondas foi enviado pela NASA à Marte e irá pousar num planalto.
Esse planalto, que curiosamente é retangular, deve ser explorado pelas sondas para que suas câmera embutidas consigam ter uma visão completa da área e enviar as imagens de volta para a Terra.

A posição e direção de uma sonda são representadas por uma combinação de coordenadas x-y e uma letra representando a direção cardinal para qual a sonda aponta, seguindo a rosa dos ventos em inglês.

![rosa dos ventos](http://i.imgur.com/li8Ae5L.png "Rosa dos Ventos")

O planalto é divido numa malha para simplificar a navegação. Um exemplo de posição seria (0, 0, N), que indica que a sonda está no canto inferior esquerdo e apontando para o Norte.

Para controlar as sondas, a NASA envia uma simples sequência de letras. As letras possíveis são "L", "R" e "M". Destas, "L" e "R" fazem a sonda virar 90 graus para a esquerda  ou direita, respectivamente, sem mover a sonda. "M" faz com que a sonda mova-se para a frente um ponto da malha, mantendo a mesma direção.

Nesta malha o ponto ao norte de (x,y) é sempre (x, y+1).

Programa que processa uma série de instruções enviadas para as sondas que estão explorando este planalto.
O formato da entrada e saída deste programa segue abaixo.

1. Escolhendo Profile
    - em application.properties spring.profiles.active=<h2,mysql,mysqldocker>
    - rodando aplicacao via container, no terminal utilizar(necessario ja ter instalado docker na maquina), nesse caso utilizaremos o h2:
    ```shell script
    docker build -t explorando-marte-image:1.0 . && docker run -d -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=h2" --name container-explorando-marte explorando-marte-image:1.0
    ```
   - utilizando docker-compose com profile mysql-docker(EM CONSTRUÇÃO)
   ```shell script
   docker-compose up
   ```
## Servico Via FrontEnd - Thymeleaf
localhost:8080/api/v1/sondas
[gif]

    

## Contrato API

A primeira linha da entrada de dados é a coordenada do ponto superior-direito da malha do planalto. Lembrando que a inferior esquerda sempre será (0,0).

O resto da entrada será informação das sondas que foram implantadas. Cada sonda é representada por duas linhas. A primeira indica sua posição inicial e a segunda uma série de instruções indicando para a sonda como ela deverá explorar o planalto.

A posição é representada por dois inteiros e uma letra separados por espaços, correpondendo à coordenada X-Y e à direção da sonda.
Cada sonda será controlada sequencialmente, o que quer dizer que a segunda sonda só irá se movimentar após que a primeira tenha terminado suas instruções.

endereco para acessar front: localhost:8080/api/v1/sondas

### POST - Criando/Enviando a Sonda - /salvarSonda

```json
{
    "nome": "sonda_nasa",
    "tamanhoSuperficieX": 5,
    "tamanhoSuperficieY": 5,
    "coordenadaX": 1,
    "coordenadaY": 2,
    "direcao": "N",
    "instrucoes": "LMLMLMLMM"
}
```

#### Retorno - 203: CREATED
O retorno consiste em apos o envio de posicao inicial e direcao da sonda, e movimentos realizados em Marte, o servico processa instrucoes(M - mover pra frente, R - girar uma direcao para direita, L - girar uma direcao para esquerda),
calculando a posicao final(x,y) da sonda apos esses movimentos e direcao.

```json
{
    "id": 1,
    "nome": "sonda_nasa",
    "coordenadaX": 1,
    "coordenadaY": 3,
    "direcao": "N"
}
```

### GET - Lista de Sondas enviadas - /sondas

#### Retorno - 200: OK
O retorno consiste em apos o envio de posicao inicial e direcao da sonda, e movimentos realizados em Marte, o servico processa instrucoes(M - mover pra frente, R - girar uma direcao para direita, L - girar uma direcao para esquerda),
calculando a posicao final(x,y) da sonda apos esses movimentos e direcao.

```json
[
    {
        "id": 1,
        "nome": "sonda_nasa",
        "coordenadaX": 1,
        "coordenadaY": 3,
        "direcao": "N"
    },
    {
        "id": 2,
        "nome": "sonda_nasa_aux",
        "coordenadaX": 5,
        "coordenadaY": 1,
        "direcao": "E"
    }
]
```

### DELETE - Deletar sonda - /deletarSonda/{id}

#### Retorno - 200: OK
Deletar uma sonda


### Fora da API, somente execucao da logica, arquivo /ViaConsole/LabSonda.java:

####Entrada de Teste:
```
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
```

#### Saída esperada:
A saída deverá contar uma linha para cada sonda, na mesma ordem de entrada, indicando sua coordenada final e direção.
```
1 3 N
5 1 E
