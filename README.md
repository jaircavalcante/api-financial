# API Pismo

API criada com objetivo de criar contas e realizar transações financeiras. 
  - Java 8
  - Swagger
  - H2 

# Execução da API!

Realizar o clone do projeto:
```sh
$ git clone <project>
```

Executar o clean e instalação do Maven na pasta do projeto:
```sh
$ mvn clean install
```

Acessar a pasta Docker presente no projeto e executar os comandos:
```sh
$ docker build -t desafio.pismo .
```
Após build, executar o comando a seguir:
```sh
$ docker run -p 8080:8080 desafio-pismo
```

### Links Uteis

| Ferramenta | Link |
| ------ | ------ |
| Swagger | http://localhost:8080/api/swagger-ui.html|
| H2 DataBase | http://localhost:8080/api/h2-console/ |

Utilizar admin/admin para acessar ao H2.

### Documentação da API

Endpoints disponíveis:
|HTTP |	Endpoint|
| ------ | ------ |
|POST	| http://localhost:8081/api/v1/accounts|
|GET	|http://localhost:8081/api/v1/accounts/{accountId}|
|POST|	http://localhost:8081/api/v1/transactions|