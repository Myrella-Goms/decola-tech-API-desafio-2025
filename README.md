## API REST com Java, Spring Boot 3, Maven, PostgreSQL e Railway ☕
O desafio do projeto consiste em construir uma API RESTful funcional utilizando boas práticas de programação. Foi utilizado o Spring Data JPA para manipulação de dados, OpenAPI para documentação automática, Swagger para visualização dos endpoints da API e deploy da mesma no Railway, utilizando o PostgreSQL como banco de dados.

## Tecnologias Utilizadas:

 <p align="center">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=java,spring,postgresql,maven,railway" />
  </a>
</p>

## Entidades criadas para o projeto:

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
