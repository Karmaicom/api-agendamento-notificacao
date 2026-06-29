# API Agendamento Notificacao

API em Java com Spring Boot para servir como base de um servico de agendamento de notificacoes.

O projeto esta em estrutura inicial e atualmente contem a aplicacao Spring Boot, dependencias para API REST, persistencia com JPA/PostgreSQL, documentacao OpenAPI/Swagger e teste de contexto da aplicacao.

## Tecnologias

- Java 21
- Spring Boot 3.5.16
- Spring Web
- Spring Data JPA
- PostgreSQL Driver
- Springdoc OpenAPI/Swagger UI
- Lombok
- Maven
- JUnit 5 e Spring Boot Test

## Requisitos

- JDK 21 ou superior
- Maven Wrapper incluido no projeto
- PostgreSQL, caso a aplicacao seja executada com JPA habilitado

## Como executar localmente

Configure os dados de conexao com o PostgreSQL em `src/main/resources/application.properties` ou por variaveis de ambiente/propriedades de linha de comando.

Exemplo de configuracao:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/agendamento_notificacao
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Depois, execute:

```bash
./mvnw spring-boot:run
```

No Windows:

```bash
.\mvnw.cmd spring-boot:run
```

Como nenhuma porta customizada foi definida em `application.properties`, a aplicacao usa a porta padrao do Spring Boot:

```text
http://localhost:8080
```

## Documentacao da API

Com a aplicacao em execucao, acesse o Swagger UI em:

```text
http://localhost:8080/swagger-ui/index.html
```

A especificacao OpenAPI fica disponivel em:

```text
http://localhost:8080/v3/api-docs
```

## Endpoints

O projeto ainda nao possui controllers ou endpoints de negocio implementados.

Quando os endpoints de agendamento e notificacao forem adicionados, esta secao deve ser atualizada com:

- metodo HTTP;
- rota;
- payload de entrada;
- payload de resposta;
- codigos de status;
- exemplos de requisicao.

## Estrutura do projeto

```text
src/main/java/br/com/javanauta/apiagendamentonotificacao
`-- ApiAgendamentoNotificacaoApplication.java

src/main/resources
`-- application.properties

src/test/java/br/com/javanauta/apiagendamentonotificacao
`-- ApiAgendamentoNotificacaoApplicationTests.java
```

## Build

Para compilar o projeto:

```bash
./mvnw clean package
```

No Windows:

```bash
.\mvnw.cmd clean package
```

## Testes

Execute os testes com:

```bash
./mvnw test
```

No Windows:

```bash
.\mvnw.cmd test
```

No estado atual, o teste de contexto depende da configuracao de um `DataSource`. Sem as propriedades de conexao com o banco, o Spring Boot nao consegue inicializar o contexto e retorna erro semelhante a:

```text
Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
```

Para executar a suite com sucesso, configure um PostgreSQL acessivel ou adicione um banco em memoria/profile especifico para testes.

## Configuracao atual

O arquivo `src/main/resources/application.properties` define apenas o nome da aplicacao:

```properties
spring.application.name=api-agendamento-notificacao
```

## Observacoes

- O projeto usa PostgreSQL como dependencia de runtime, mas ainda nao possui propriedades de conexao configuradas.
- O projeto possui Spring Data JPA, mas ainda nao contem entidades ou repositories.
- O projeto possui Spring Web e Springdoc OpenAPI, mas ainda nao contem controllers.
- A documentacao deve evoluir junto com os endpoints de agendamento de notificacoes.
