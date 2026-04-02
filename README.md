# Simulacao de Veiculos

Projeto de simulacao em Java com duas formas de visualizacao:

- modo servidor HTTP para alimentar um front-end Angular;
- modo console para manter a visualizacao original em terminal.

## Estrutura

- `src/trabalho/Trabalho.java`: ponto de entrada da aplicacao.
- `src/trabalho/Mundo.java`: motor da simulacao, responsavel por mapa, geracao, colisao e snapshots do estado.
- `src/trabalho/Veiculo.java`: classe base com estado e logica de movimento.
- `src/trabalho/Carro.java`, `Moto.java`, `Caminhao.java`: tipos concretos de veiculo.
- `src/trabalho/SimulacaoHttpServer.java`: servidor HTTP com endpoints para o front-end.
- `frontend/`: aplicacao Angular que exibe a simulacao em grade.

## Legenda do mapa

- `#`: limite do mapa
- `.`: espaco vazio
- `F`: fabrica
- `C`: carro
- `T`: caminhao
- `M`: moto

## Executar back-end com Java 21

O projeto inclui o script `run-java21.ps1`, que usa o JDK localizado em `C:\Users\lipi-\.jdks\ms-21.0.10` e sobe o servidor em `http://localhost:8080`.

```powershell
powershell -ExecutionPolicy Bypass -File .\run-java21.ps1
```

### Endpoints disponiveis

- `GET /api/state`: retorna o estado atual da simulacao.
- `POST /api/pause`: pausa a atualizacao automatica.
- `POST /api/resume`: retoma a atualizacao automatica.
- `POST /api/step`: avanca um passo quando estiver pausado.
- `POST /api/reset`: reinicia a simulacao.

## Executar front-end Angular

Na primeira vez, instale as dependencias:

```powershell
cd .\frontend
$cache = Join-Path (Get-Location) '.npm-cache'
if (-not (Test-Path $cache)) { New-Item -ItemType Directory -Path $cache | Out-Null }
$env:npm_config_cache = (Resolve-Path $cache).Path
npm install
```

Depois, rode o front:

```powershell
cd .\frontend
npm start
```

Abra `http://localhost:4200`.

### Ordem recomendada para subir a aplicacao

1. Inicie o back-end com `.\run-java21.ps1`.
2. Em outro terminal, entre em `frontend/` e execute `npm start`.
3. Abra `http://localhost:4200` para acompanhar a simulacao.

## Executar modo console

Para manter a visualizacao antiga no terminal:

```powershell
powershell -ExecutionPolicy Bypass -File .\run-console-java21.ps1
```

## Rodar testes

```powershell
powershell -ExecutionPolicy Bypass -File .\run-tests-java21.ps1
```

## Build do NetBeans/Ant

O arquivo `nbproject/project.properties` foi atualizado para `javac.source=21` e `javac.target=21`.

## Observacoes

- O servidor atualiza a simulacao automaticamente a cada 300 ms.
- O Angular faz polling do estado para redesenhar o mapa e os indicadores.
- No modo console, a simulacao continua em loop infinito.
- A cada iteracao os veiculos se movem, podem colidir e podem gerar novos veiculos ao entrar em fabricas.
- Caminhoes removem carros e motos em colisao.
- Carros removem motos em colisao.
