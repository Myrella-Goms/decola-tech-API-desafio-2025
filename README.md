## BEM VINDO(A) AO SEU GERENCIAMENTO DE AGÊNCIAS!
A seguinte aplicação visa gerenciar agências de um banco, trazendo também informaçôes de funcionários e clientes associados. Podemos verificar o status, numero e endereço de cada agência, bem como a quantidade de funcionarios e clientes por agencia, além de outros atributos inerentes a essas duas classes.

## Tecnologias utilizadas para o desenvolvimento do projeto:

 <p align="center">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=java,spring,postgresql,maven,railway" />
  </a>
</p>

## Entidades trabalhadas no projeto:
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
## Desenvolvimento da API:

1. Camadas:
   
   -Domain:
 - Model: Contém as entidades do banco de dados, incluindo Agencia, Clientes e Conta.
 - Repository: Responsável pela interação com a camada de persistência de dados, realizando o acesso ao banco de dados e detendo métodos personalizados de consulta.
   
 - DTO (Data Transfer Object): Encapsula e estrutura as informações que serão enviadas ou recebidas pelos endpoints sem expor as entidades, garantindo uma melhor organização e segurança da API.

   -Service:
 - Service:Inteface com os métodos que serão implementados pela camada de negócios.
 - ServiceImpl: Responsável pela lógica de negócio da aplicação. Ela atua como intermediária entre as camadas Controller e Repository.
   
 - Controller: Controladores REST que mapeiam os endpoints para as operações CRUD definidas e manipulam as requisições HTTP.
 - Config: Configuração do swagger open ai;
 - Mappper: Mapeamento de entidade pra DTO e DTO pra entidade usando o mapstruct;
 - Exception:

2. Operações CRUD:

 - Create: Permite criar novas contas, clientes e funcionários com base nas regras de négocio estabelecidas
 - Read: Permite buscar a agência pelo número da mesma, funcionários e clientes pelo id. Também permite listar todas as agências, clientes e funcionários.
 - Update: Permite atualizar as informações específicas das entidades, como status da agencia, salário e cargo dos funcionários, e algumas informações dos clientes.
 - Delete: Permite deletar um usuário do sistema.
 
4. Tratamento de Exceções:

 Implementação de um manipulador global de exceções (GlobalExceptionHandler) para lidar com exceções comuns, como NoSuchElementException e IllegalArgumentException, e retornar mensagens apropriadas ao cliente.

## Imagens da aplicação:
 <img src="">
 <img src="">
 <img src="">
 <img src="">

 ## Deploy da API pelo Railway
https://decola-tech-api-desafio-2025-production.up.railway.app/swagger-ui/index.html#/
