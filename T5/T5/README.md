# T5 - Coloração de Mapas com DSatur

Este projeto implementa a modelagem do mapa político do Brasil como um grafo não direcionado e aplica o algoritmo DSatur para colorir seus vértices (estados) com um baixo número de cores, garantindo que estados vizinhos não tenham a mesma cor.

## Estrutura do Projeto

```
T5/
├── README.md
├── T5.md
├── dados/
│   └── brasil.txt
└── src/
    ├── Main.java
    ├── Graph.java
    ├── GraphColoringDSatur.java
    ├── Bag.java
    └── In.java
```

## Como Executar

Para compilar e executar o programa, utilize os seguintes comandos no terminal (a partir da raiz do projeto):

```bash
# Compilar
javac -d src src/*.java

# Executar
java -cp src Main dados/brasil.txt
```

## Vídeo Explicativo

[Link para o vídeo explicativo] (Substitua por seu link)
