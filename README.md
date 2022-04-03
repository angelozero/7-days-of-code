# 7 Days Of Code - By Alura

  - [Day 01](https://github.com/angelozero/7-days-of-code/blob/main/01-DAY.md) 
  - [Day 02](https://github.com/angelozero/7-days-of-code/blob/main/02-DAY.md)
  - [Day 02](https://github.com/angelozero/7-days-of-code/blob/main/03-DAY.md)

O que significa?

São 7 exercícios práticos, enviados por e-mail, com as seguintes características:

- Dificuldade crescente de desafios;
- Feedback da comunidade;
- O hábito de praticar.

---
## Dia 01
Você conhece o IMDB? É provavelmente a plataforma mais famosa que agrupa basicamente todos os filmes, séries, programas de TV, atores, etc., do mundo. Você pode imaginar que o banco de dados deles deve ser colossal!
No desafio de hoje, você vai fazer o seu código Java rodar e consumir a API do IMDB! Seu objetivo será imprimir os resultados de uma busca na linha de comando.
Explicando melhor, você vai usar essa API para pesquisar os top 250 filmes e imprimir o JSON correspondente no console da sua IDE.
Para isso, você pode acessar o webservice ou API da plataforma em:

https://imdb-api.com/api

O site do IMDB tem uma documentação bem legal para você se familiarizar com os parâmetros da chamada e analisar o retorno.
Ahh, também será preciso gerar uma APIKey (uma chave de acesso), registrando o seu email no site. Com a chave em mãos, você poderá buscar filmes, séries, etc., através da API.
Por exemplo, para buscar o nome de um filme, basta usar:

`https://imdb-api.com/en/API/Top250Movies/<apiKey>https://imdb-api.com/en/API/Top250Movies/`

O resultado da pesquisa será um JSON parecido com esse:
```json
{
  "items": [
    {
      "id": "tt5491994",
      "rank": "1",
      "title": "Planet Earth II",
      "fullTitle": "Planet Earth II (2016)"
      //...
    }
  ]
}…
```
Mas chegou a hora de escrever o código e fazer a coisa funcionar! Vamos lá? Vou passar aqui abaixo uma espécie de passo-a-passo, para você não se perder muito neste primeiro dia. O que você vai precisar fazer:

 - Criar uma conta no IMDB para ter a chave de acesso ao serviço (apiKey), mas cuidado, essa chave não deve ser commitada no Github ou em outro repositório!

 - Criar o código Java que executará uma requisição HTTP do tipo GET. Você pode usar o pacote java.net.http e as classes HttpRequest, HttpClient e HttpResponse, além da classe URI

- Executar a requisição e pegar a resposta (o JSON)

- Imprimir o corpo da resposta no console

---
## Dia 02

A tarfea para o 2 dia é extrair o título do filme e a URL da imagem a partir da resposta JSON.

Existem várias maneiras de fazer isso e, neste momento, não se preocupe ainda em escrever um código elegante. 
Tente usar os métodos da classe java.lang.String como substring(), split() e replace(). 
Você também pode usar Regex (através das classes Matcher e Pattern do pacote java.util.regex) para encontrar uma string que siga um determinado padrão.

Com o resultado do parseamento, você deverá criar diferentes listas, cada uma com um atributo do filme. 

Uma lista com os títulos, outra com a URL da imagem e assim por diante. 

Exemplo:

```java
    List<String> titles = //parseia o título de cada filme do JSON;

    List<String> urlImages = //parseia a URL do pôster de cada filme do JSON;

    // outras listas, com os anos (year) e as notas (imDbRating)
```
--- 
## Dia 03
No desafio de hoje, a ideia será modelar, ou pelo menos iniciar uma modelagem melhor do seu código.

Pensando um pouco sobre Orientação a Objetos, uma pergunta simples pode ajudar: 
no caso do seu projeto, o título e o pôster se referem a que tipo de objeto? 
A um filme, claro. Mas você ainda não tem nenhuma estrutura que defina o que é um filme.

Qual vai ser a cara disso? Um filme (Movie) deve ter os seguintes atributos:

```json
título (title)
URL da imagem do pôster (urlImage)
nota (rating)
ano (year)
```

Em outras palavras, em vez de ter várias listas diferentes, uma para cada atributo do filme, 
é bem melhor organizar isso em uma única `List<Movie>`, onde cada filme encapsula os seus próprios dados. 
Bora implementar essa classe?

*Obs.: Para o terceiro dia implementei testes unitários, pois o 1 dia ja contemplava o que o desafio pedia*

---
## Dia 04

---

-------------------------
---- FIX SOME ERRORS ----
-------------------------

OBS: 
  - For the following error 
```
java: Internal error in the mapping processor: 
java.lang.NullPointerException: 
Cannot invoke "java.net.URL.toExternalForm()"
```
  - To fix this in IntelliJ go to: 
```
File | Settings | Build, Execution, Deployment | Compiler | user-local build process vm options
``` 
 and set 
```
-Djps.track.ap.dependencies=false
```
