# API Agendamento Notificacao

API REST em Java com Spring Boot para cadastro e consulta de agendamentos de notificacoes.

O projeto permite registrar uma notificacao com destinatario, mensagem e data/hora de envio. Ao salvar um agendamento, a aplicacao define automaticamente a data/hora de agendamento e o status inicial `AGENDADO`.

## Tecnologias

- Java 21
- Spring Boot 3.5.16
- Spring Web
- Spring Data JPA
- PostgreSQL
- Springdoc OpenAPI/Swagger UI
- MapStruct
- Lombok
- Maven
- Docker e Docker Compose
- JUnit 5 e Spring Boot Test

## Requisitos

Para executar localmente:

- JDK 21 ou superior
- Maven Wrapper incluido no projeto
- PostgreSQL

Para executar com Docker:

- Docker
- Docker Compose

## Configuracao

A configuracao principal fica em `src/main/resources/application.yaml`.

Valores atuais:

```yaml
server:
  port: 8081

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/bd-apiagendamentonotificacao
    username: javanauta
    password: Javanauta@2026
  jpa:
    hibernate:
      ddl-auto: update
```

O projeto tambem pode receber as credenciais do banco por variaveis de ambiente:

```bash
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/bd-apiagendamentonotificacao
SPRING_DATASOURCE_USERNAME=javanauta
SPRING_DATASOURCE_PASSWORD=Javanauta@2026
```

## Como executar localmente

Com o PostgreSQL em execucao e o banco `bd-apiagendamentonotificacao` criado, execute:

```bash
./mvnw spring-boot:run
```

No Windows:

```bash
.\mvnw.cmd spring-boot:run
```

A aplicacao sobe em:

```text
http://localhost:8081
```

## Como executar com Docker

Gere o pacote da aplicacao:

```bash
./mvnw clean package
```

No Windows:

```bash
.\mvnw.cmd clean package
```

Suba os servicos:

```bash
docker compose up --build
```

O `docker-compose.yaml` inclui:

- `postgres`: banco PostgreSQL 16;
- `pgadmin`: interface web para administrar o banco;
- `app`: aplicacao Spring Boot.

PgAdmin fica disponivel em:

```text
http://localhost:5050
```

Credenciais do PgAdmin:

```text
Email: admin@admin.com
Senha: Javanauta@2026
```

> Observacao: a aplicacao esta configurada para subir na porta `8081`, mas o `docker-compose.yaml` atual publica `8080:8080` para o servico `app`. Para acessar a API via Compose, ajuste o mapeamento para `8080:8081` ou altere `server.port` para `8080`.

## Documentacao da API

Com a aplicacao em execucao, acesse o Swagger UI em:

```text
http://localhost:8081/swagger-ui/index.html
```

A especificacao OpenAPI fica disponivel em:

```text
http://localhost:8081/v3/api-docs
```

## Endpoints

### Criar agendamento

```http
POST /agendamento
Content-Type: application/json
```

Corpo da requisicao:

```json
{
  "emailDestinatario": "destinatario@email.com",
  "telefoneDestinatario": "11999999999",
  "mensagem": "Mensagem da notificacao",
  "dataHoraEnvio": "30-06-2026 14:30:00"
}
```

O campo `dataHoraEnvio` usa o formato:

```text
dd-MM-yyyy HH:mm:ss
```

Resposta `201 Created`:

```json
{
  "id": 1,
  "emailDestinatario": "destinatario@email.com",
  "telefoneDestinatario": "11999999999",
  "mensagem": "Mensagem da notificacao",
  "dataHoraEnvio": "30-06-2026 14:30:00",
  "statusNoficacao": "AGENDADO"
}
```

### Buscar agendamento por ID

```http
GET /agendamento/{id}
```

Exemplo:

```http
GET /agendamento/1
```

Resposta `200 OK`:

```json
{
  "id": 1,
  "emailDestinatario": "destinatario@email.com",
  "telefoneDestinatario": "11999999999",
  "mensagem": "Mensagem da notificacao",
  "dataHoraEnvio": "30-06-2026 14:30:00",
  "statusNoficacao": "AGENDADO"
}
```

Quando o agendamento nao e encontrado, a API retorna `400 Bad Request` com uma mensagem de erro.

## Status de notificacao

Os status disponiveis sao:

- `AGENDADO`
- `ENVIADO`
- `CANCELADO`

No cadastro atual, novos registros sao criados automaticamente com status `AGENDADO`.

## Exemplos com cURL

Criar um agendamento:

```bash
curl -X POST http://localhost:8081/agendamento \
  -H "Content-Type: application/json" \
  -d '{"emailDestinatario":"destinatario@email.com","telefoneDestinatario":"11999999999","mensagem":"Mensagem da notificacao","dataHoraEnvio":"30-06-2026 14:30:00"}'
```

Buscar um agendamento:

```bash
curl http://localhost:8081/agendamento/1
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

O teste atual carrega o contexto da aplicacao. Como o projeto usa JPA/PostgreSQL, e necessario manter um banco acessivel ou sobrescrever as propriedades de datasource para o ambiente de teste.

## Estrutura do projeto

```text
src/main/java/br/com/javanauta/apiagendamentonotificacao
|-- ApiAgendamentoNotificacaoApplication.java
|-- controllers
|   `-- AgendamentoController.java
|-- dtos
|   |-- AgendamentoRequestDTO.java
|   `-- AgendamentoResponseDTO.java
|-- entities
|   |-- Agendamento.java
|   `-- enums
|       `-- StatusNoficacaoEnum.java
|-- exceptions
|   |-- GlobalExceptionHandler.java
|   `-- NotFoundException.java
|-- mappers
|   `-- IAgendamentoMapper.java
|-- repositories
|   `-- AgendamentoRepository.java
`-- services
    `-- AgendamentoService.java
```

## Observacoes

- A persistencia e feita com Spring Data JPA em PostgreSQL.
- O mapper entre DTOs e entidade e gerado pelo MapStruct.
- A entidade `Agendamento` preenche `dataHoraAgendamento` e `statusNoficacao` automaticamente antes de persistir.
- O nome do enum no codigo esta como `StatusNoficacaoEnum`.
