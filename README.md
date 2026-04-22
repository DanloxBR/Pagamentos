# 💳 API de Pagamentos

API REST desenvolvida em **Java + Spring Boot** para gerenciamento de pagamentos e carteiras digitais.

---

## 🚀 Tecnologias utilizadas

* ☕ Java 8+
* 🌱 Spring Boot
* 📦 Spring Data JPA
* 🐘 PostgreSQL
* 📄 Swagger / OpenAPI
* 🔗 REST API

---

## 📌 Funcionalidades

* ✅ Criar carteira
* 💰 Consultar saldo
* 🔄 Realizar pagamentos
* 📊 Listar transações
* 🔍 Buscar pagamentos por ID

---

## 📂 Estrutura do Projeto

```
src/main/java/com/danieldev/pagamento
│
├── controller   # Camada de entrada (REST)
├── service      # Regras de negócio
├── repository   # Acesso ao banco de dados
├── entity       # Entidades JPA
├── dto          # Objetos de transferência
└── config       # Configurações (Swagger, CORS, etc)
```

---

## ⚙️ Como rodar o projeto

### 🔧 Pré-requisitos

* Java 8+
* Maven
* PostgreSQL

---

### 🛠️ Configurar banco de dados

Crie um banco no PostgreSQL:

```sql
CREATE DATABASE pagamentos;
```

Configure no `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/pagamentos
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### ▶️ Executar a aplicação

```bash
mvn spring-boot:run
```

---

## 🌐 Endpoints principais

| Método | Endpoint        | Descrição          |
| ------ | --------------- | ------------------ |
| POST   | /carteiras      | Criar carteira     |
| GET    | /carteiras      | Listar carteiras   |
| GET    | /carteiras/{id} | Buscar carteira    |
| POST   | /pagamentos     | Realizar pagamento |
| GET    | /pagamentos     | Listar pagamentos  |

---

## 📖 Documentação da API

Após subir o projeto, acesse:

```
http://localhost:8080/swagger-ui.html
```

---

## 🧪 Testes com Postman

Você pode testar os endpoints usando o Postman.

Exemplo de JSON para pagamento:

```json
{
  "valor": 100.0,
  "carteiraOrigemId": 1,
  "carteiraDestinoId": 2
}
```

---

## 💡 Conceitos aplicados

* Arquitetura em camadas
* Separação de responsabilidades
* RESTful API
* Persistência com JPA
* Boas práticas de backend

---

## 📌 Melhorias futuras

* 🔐 Autenticação com JWT
* 📊 Dashboard de transações
* 📈 Logs e monitoramento
* 💳 Integração com gateways de pagamento

---

## 👨‍💻 Autor

Desenvolvido por **Daniel Oliveira**

🔗 GitHub: https://github.com/DanloxBR

---

## ⭐ Contribuição

Sinta-se à vontade para abrir issues ou contribuir com melhorias!

---

## 📜 Licença

Este projeto está sob a licença MIT.
