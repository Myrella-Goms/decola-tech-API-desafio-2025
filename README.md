## ✅💳 BEM VINDO(A) AO SEU GERENCIAMENTO DE AGÊNCIAS!
A seguinte aplicação visa gerenciar agências de um banco, trazendo também informaçôes de funcionários e clientes associados. Podemos verificar o status, numero e endereço de cada agência, bem como a quantidade de funcionarios e clientes por agencia, além de outros atributos inerentes a essas duas classes.

## 💻 Tecnologias utilizadas para o desenvolvimento da aplicação :

 <p align="center">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=java,spring,postgresql,maven,railway" />
  </a>
</p>

## Modelagem do sistema ⬇️
  
```mermaid
classDiagram
    class Agencia {
        +String unidade
        +String numero
        +String CEP
        +String cidade
        +String estado
        +String status
        +List<Clientes> clientes
        +List<Funcionarios> funcionarios
    }

    class Cliente {
        +String nome
        +String cpf
        +String telefone
        +String email
        +String senha
    }

    class Funcionarios {
        +String nome
        +String cpf
        +String telefone
        +Data aniversario
        +String cargo
        +String salario
    }

    Agencia "1" --> "*" Cliente
    Agencia "1" --> "*" Funcionarios
```
## 📱 Desenvolvimento:
📄 Camadas:
   
1. Domain:
 - Model: Contém as classes mapeadas em entidades no banco de dados, incluindo Agencia, Clientes e Funcionários.
 - Repository: Responsável pela interação com a camada de persistência de dados, realizando o acesso ao banco de dados e detendo métodos consulta personalizados.
   
2. DTO (Data Transfer Object): Encapsula e estrutura as informações que serão enviadas ou recebidas pelos endpoints sem expor as entidades, garantindo uma melhor organização e segurança da API.
   
4. Mappper: Mapeamento de entidade pra DTO e DTO pra entidade usando o mapstruct;
   
6. Service:
 - Service: Inteface com os métodos que serão implementados pela camada de negócios, que foram: findById/numero (no caso da Agencia), findALL, create, update e delete.
 - ServiceImpl: Responsável pela lógica de negócio da aplicação.
     
5. Controller: Controladores REST que mapeiam os endpoints para as operações CRUD definidas e manipulam as requisições HTTP.
   
7. Config: Configuração do swagger open ai;
   
9. Exception: Criei exceções personalizadas e implementei de um manipulador global de exceções (GlobalExceptionHandler) para lidar com exceções comuns, como IllegalArgumentException, e retornar mensagens apropriadas ao cliente.

## Imagens da aplicação:
 <img src="https://github.com/Myrella-Goms/decola-tech-API-desafio-2025/blob/master/imagens/Captura%20de%20tela%202025-03-23%20152909.png">
 <img src="https://github.com/Myrella-Goms/decola-tech-API-desafio-2025/blob/master/imagens/Captura%20de%20tela%202025-03-23%20150047.png">
 <img src="https://github.com/Myrella-Goms/decola-tech-API-desafio-2025/blob/master/imagens/Captura%20de%20tela%202025-03-23%20150115.png">

 ## 🚀 Deploy da API pelo Railway
https://decola-tech-api-desafio-2025-production.up.railway.app/swagger-ui/index.html#/
