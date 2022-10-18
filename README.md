# Desafio MkData

Aplicação full stack para gerenciamento de clientes.

# Tecnologias

Backend:

- Java
- Spring-boot
- Hibernate
- PostgreSQL
- Docker

Frontend:

- Javascript
- React
- Styled-components

Rodando localmente, sem deploy até o momento.

Requisitos:

Teste prático para vaga de desenvolvedor, conforme conversado:
1) Criar tela de login, com usuário e senha (fixo).
2) Criar CRUD de cadastro de Grupo de Clientes contendo: nome e ativo.
3) Criar CRUD de cadastro de clientes contendo: 
     - a) nome, obrigatório;
     - b) tipo (pessoa física ou jurídica), obrigatório;
     - c) CPF (se pessoa física) ou CNPJ (se pessoa jurídica), obrigatório;
     - d) RG (se pessoa física) ou IE (se pessoa jurídica);
     - e) Data de Cadastro;
     - f) Grupo: Permitir selecionar somente uma opção.
     - g) Ativo (se está ativo);     
     - h) Ao gravar validar se já existe um cliente cadastrado com o CPF/CNPJ informado.

## Iniciando o projeto

Clone o repositório:

```
git clone git@github.com:Valdeci97/mkdata.git
```
Inicie os containeres:

```
docker compose up -d
```

Inicie o backend

```
cd backend && mvn spring-boot:run
```

Abra outro terminal e inicie o frontend:

```
cd ../frotend && npm i && npm start
```

A aplicação estará rodando em sua máquina na porta 3000; na porta 5050 haverá uma instância do pgadmin para que acompanhe o banco de dados, caso queira.
