# Aula 13 de Estrutura de Dados I — listas duplamente encadeadas

Dois projetos Java independentes exercitam inserção e percurso em listas duplamente encadeadas. Cada projeto tem suas próprias classes `ListaDupla` e `Celula`, com referências para elementos anteriores e seguintes.

## Atividade 1 — ordenação e remoção de primos

O programa sorteia mil inteiros de −9.999 a 9.999 e exibe o vetor na ordem do sorteio. Ele insere os números diretamente na posição correta da lista, imprime em ordem crescente, inverte a lista e imprime em ordem decrescente. A última saída mostra a lista após remover os números primos. [Código da atividade](atividade1/src/atividade1/) · [Vídeo da atividade 1](https://youtu.be/2RSs-LGSNEA).

## Atividade 2 — busca de uma sequência

O programa insere 51 milhões de inteiros sorteados de 1 a 60 em uma lista e procura a sequência `1, 15, 16, 25, 32, 36` nos dois sentidos de percurso. A saída indica as posições das ocorrências e a contagem por sentido. [Código da atividade](atividade2/src/atividade2/) · [Vídeo da atividade 2](https://youtu.be/ne5Y-XQI8ew).

## Como executar

Use o JDK 17 ou posterior. Na raiz do repositório, rode a atividade 1 no PowerShell.

```powershell
javac --release 17 -encoding UTF-8 -d build (Get-ChildItem -Path atividade1/src -Recurse -Filter *.java -File).FullName
java -cp build atividade1.Program
```

Para experimentar a atividade 2, passe o número de valores a sortear. O exemplo usa 10 mil valores. Sem o argumento, o programa usa o volume original de 51 milhões de nós, que exige mais memória. A busca percorre a lista diretamente em cada sentido.

```powershell
javac --release 17 -encoding UTF-8 -d build-atividade2 (Get-ChildItem -Path atividade2/src -Recurse -Filter *.java -File).FullName
java -cp build-atividade2 atividade2.Programa 10000
```
