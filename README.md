# Simulacao de Veiculos

Projeto antigo de faculdade em Java que simula movimentacao aleatoria, colisao e geracao de veiculos em fabricas dentro de um mapa 2D no console.

## Estrutura

- `src/trabalho/Trabalho.java`: ponto de entrada da aplicacao.
- `src/trabalho/Mundo.java`: controla mapa, geracao, colisao e desenho usando uma unica colecao de veiculos.
- `src/trabalho/Veiculo.java`: classe base com estado e logica de movimento.
- `src/trabalho/Carro.java`, `Moto.java`, `Caminhao.java`: tipos concretos de veiculo.

## Legenda do mapa

- `#`: limite do mapa
- `.`: espaco vazio
- `F`: fabrica
- `C`: carro
- `T`: caminhao
- `M`: moto

## Executar com Java 21

O projeto inclui o script `run-java21.ps1`, que usa o JDK localizado em `C:\Users\lipi-\.jdks\ms-21.0.10`.

```powershell
powershell -ExecutionPolicy Bypass -File .\run-java21.ps1
```

## Rodar testes

```powershell
powershell -ExecutionPolicy Bypass -File .\run-tests-java21.ps1
```

## Build do NetBeans/Ant

O arquivo `nbproject/project.properties` foi atualizado para `javac.source=21` e `javac.target=21`.

## Observacoes

- A simulacao roda em loop infinito.
- A cada iteracao os veiculos se movem, podem colidir e podem gerar novos veiculos ao entrar em fabricas.
- Caminhoes removem carros e motos em colisao.
- Carros removem motos em colisao.
