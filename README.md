## API REST com Java, Spring Boot 3, Maven, PostgreSQL e Railway ☕
O seguinte projeto teve como objetivo desenvolver uma API RESTful com contexto bancário, utilizando boas práticas de programação, usando Java com Spring Boot para gerenciar usuários, contas bancárias, cartões de crédito, transações, histórico de compras e endereço do usuário.

## Tecnologias Utilizadas:

 <p align="center">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=java,spring,postgresql,maven,railway" />
  </a>
</p>

## Entidades criadas para o projeto:
```mermaid
classDiagram
    class User {
        +String name
        +String cpf
        +String phone
        +String birthdate
        +String email
        +String password
        +Account account
        +Card card
        +Address address
    }

    class Account {
        +String number
        +String agency
        +BigDecimal balance
        +BigDecimal limit
        +List<Transaction> transactions
    }

    class Card {
        +String number
        +BigDecimal limit
        +BigDecimal currentBill
        +List<Purchase> purchases
    }

    class Transaction {
        +String date
        +String description
        +BigDecimal amount
    }

    class Purchase {
        +String date
        +String description
        +BigDecimal amount
    }

    class Address {
        +String zipcode
        +String street
        +String city
        +String state
    }

    User "1" --> "1" Account
    User "1" --> "1" Card
    User "1" --> "1" Address
    Account "1" --> "*" Transaction
    Card "1" --> "*" Purchase
```
## Desenvolvimento da API:

1. Estrutura:

 Entity: Contém as entidades do banco de dados, incluindo User, Account, Card, Transactions, Purchases e Address.
 DTO (Data Transfer Object): Encapsula e estrutura as informações que serão enviadas ou recebidas, garantindo uma melhor organização e separação de preocupações.
 Repository: Responsável pela interação com a camada de persistência de dados, gerenciando a comunicação com o banco de dados.
 Service: Responsável pela lógica de negócio da aplicação. Ela atua como intermediária entre o Controller e o Repository.
 Controller: Controladores REST que mapeiam os endpoints para as operações CRUD e manipulam as requisições HTTP.

2. Operações CRUD:

 Create: Permite criar novos usuários no sistema com suas respectivas contas, cartões, funcionalidades e notícias.
 Read: Permite buscar usuários por ID e listar todos os usuários cadastrados.
 Update: Permite atualizar as informações de um usuário existente.
 Delete: Permite deletar um usuário do sistema.
 
4. Tratamento de Exceções:

 Implementação de um manipulador global de exceções (GlobalExceptionHandler) para lidar com exceções comuns, como NoSuchElementException e IllegalArgumentException, e retornar mensagens apropriadas ao cliente.

## Imagens da aplicação:
 <img src="https://github.com/Myrella-Goms/decola-tech-API-desafio-2025/blob/master/Captura%20de%20tela%202025-03-02%20204805.png">
 <img src="https://github.com/Myrella-Goms/decola-tech-API-desafio-2025/blob/master/Captura%20de%20tela%202025-03-02%20204821.png">
 <img src="https://github.com/Myrella-Goms/decola-tech-API-desafio-2025/blob/master/Captura%20de%20tela%202025-03-02%20205206.png">
 <img src="https://github.com/Myrella-Goms/decola-tech-API-desafio-2025/blob/master/Captura%20de%20tela%202025-03-02%20180252.png">
 <img src="https://github.com/Myrella-Goms/decola-tech-API-desafio-2025/blob/master/Captura%20de%20tela%202025-03-09%20182450.png">

 ## Meu JSON

{
  "name": "Myrella Gomes",
  "cpf": "123.456.789-00",
  "phone": "(11) 98765-4321",
  "birthdate": "1995-06-15T08:30:00.000Z",
  "email": "myrella.gomes@example.com",
  "password": "SenhaForte123!",
  "account": {
    "number": "123456-7",
    "agency": "0001",
    "balance": 2500.75,
    "limit": 5000.00,
    "transactions": [
      {
        "date": "2025-03-09T14:30:00.000Z",
        "description": "Compra em supermercado",
        "amount": -150.99
      },
      {
        "date": "2025-03-08T10:15:00.000Z",
        "description": "Transferência recebida",
        "amount": 500.00
      }
    ]
  },
  "card": {
    "number": "4111 1111 1111 1111",
    "limit": 3000.00,
    "currentBill": 1200.50,
    "dueDate": "2025-03-25",
    "bestPurchaseDay": "2025-03-15T00:00:00.000Z",
    "purchases": [
      {
        "date": "2025-03-07T19:45:00.000Z",
        "description": "Compra em loja de roupas",
        "amount": -320.75
      },
      {
        "date": "2025-03-05T13:20:00.000Z",
        "description": "Almoço em restaurante",
        "amount": -85.50
      }
    ]
  },
  "address": {
    "zipcode": "01010-001",
    "street": "Avenida Paulista, 1000",
    "city": "São Paulo",
    "state": "SP"
  }
}


 ## Documentação da API (Swagger)
https://decola-tech-api-desafio-2025-production.up.railway.app/swagger-ui/index.html#/
