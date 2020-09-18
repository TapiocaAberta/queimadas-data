# leo-crawler project

Este é um projeto feito com Quarkus para coletar os dados das queimadas disponíveis no [site do Inpe](http://queimadas.dgi.inpe.br/queimadas/portal-static/estatisticas_estados/)

Para saber mais sobre quarkus acesse o site: [https://quarkus.io/](https://quarkus.io/)

# Executando projeto

Para executar o projeto, é necessário ter **Maven** e **Java 11+** instalados em sua máquina. 

Após o clone do projeto, é preciso editar o arquivo `application.properties`, alterando o valor de `data.path`, inserindo ali o local onde os arquivos serão gerados.

compile o projeto com o seguinte comando:

```
./mvnw clean install
```

Com o sucesso do comando a seguir, é possível executar o arquivo `leo-crawler-1.0.0-SNAPSHOT-runner.jar` presente na pasta `target`. O seguinte commando irá mostrar os argumentos disponíveis

```
java -jar leo-crawler-1.0.0-SNAPSHOT-runner.jar --help

Usage: leo-crawler [-abhrsV]
  -a, --all       Get all data, biomeas, states, regions
  -b, --biome     Get only the  biome data
  -h, --help      Show this help message and exit.
  -r, --region    Get only the region data
  -s, --state     Get only the  state data
  -V, --version   Print version information and exit.
```

