# Imersão Java Alura

![MIT License](https://img.shields.io/github/license/krodrigo/alura-imersao-java)

## Rodando localmente

Pré requisito:  
Para esse projeto, estou usando dev container no visual studio code.  
[Visual studio dev container](https://code.visualstudio.com/docs/remote/containers)

Clone o projeto

```bash
  git clone https://github.com/krodrigo/alura-imersao-java.git
```

Entre no diretório do projeto

```bash
  cd alura-imersao-java.git
```

Abra o visual studio code na pasta do projeto

```bash
  code .
```

## Dia 01
Consumir, usando java, a API do IMDB dos 250 melhores filmes.  
Criar um aplicação java que vai consumir a API do IMDB e exibir no terminal a resposta.  
A exibição do resultado foi formatada com cores e rating visual.

A url da api foi alterada por um mock, pois o imdb ficou indisponível.

Resultado do primero dia
![Resultado dia 01](resultado-dia-01.png)


## Dia 02
Desenvolver um método para gerar as figurinhas de cada poster de filme.  
As imagens de cada filme estão sendo gravadas em um diretório de output, que é criado automaticamente caso não exista.  
A imagem gerada tem um texto que varia em função do rating que o filme tem no imdb.  
O texto da imagem usa uma fonte personalizada (IMPACT) e está centralizado horizontalmente, abaixo do poster

Resultado do segundo dia
![Resultado dia 01](resultado-dia-02.png)