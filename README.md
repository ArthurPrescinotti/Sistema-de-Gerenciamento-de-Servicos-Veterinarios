# Sistema de Gerenciamento de Veterinario com Jwt Token
 Sistema de Gerenciamneto de Veterinario utilizando o Java Spring Boot de Backend. 
 
 Realizado por:  
   - Arthur Prescinotti Severino  
   - Pedro Henrique França

## Passo a Passo de como rodar o programa em Swagger
 1. Passo: Verificar se o MongoDB e Java está instalado na maquina.  
 2. Passo: Abrir o pasta BackEnd em um Idea para Rodar o Java(Exemplo: Eclipse, Intellij).  
 3. Passo: Rodar o Main.java.  
 4. Passo: Abrir o localhost:8092/api-docs     
 5. Passo: Primerio tem que cadastrar um usuario.
 6. Passo: Depois de cadastrado vai em Credential-controller para gerar um token.
 7. Passo: Copiando o Token coloque ele em Available authorizations(cadeado em qualquer operação do CRUD).
 8. Passo: Quando for fazer algum CRUD coloque o Token em Authorization 

## Endpoints:
Usuario:  
- http://localhost:8092/projeto/api/v1/cadastro
  
Pessoa:   
-   http://localhost:8092/projeto/api/v1/pessoas  

Animal:  
- http://localhost:8092/projeto/api/v1/animal  

Servico:  
-  http://localhost:8092/projeto/api/v1/servicos 


