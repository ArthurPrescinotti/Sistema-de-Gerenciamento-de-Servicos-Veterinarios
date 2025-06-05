# Sistema de Gerenciamento de Veterinario com Jwt Token
 Sistema de Gerenciamneto de Veterinario utilizando o Java Spring Boot de Backend. 
 
 Realizado por:  
   - Arthur Prescinotti Severino  
   - Pedro Henrique França

## Endpoints:
Usuario:  
- http://localhost:8090/projeto/api/v1/cadastro

Login:
- http://localhost:8090/projeto/api/v1/login
  
Pessoa:   
-   http://localhost:8090/projeto/api/v1/pessoas  

Animal:  
- http://localhost:8090/projeto/api/v1/animais  

Servico:  
-  http://localhost:8090/projeto/api/v1/servicos

## Passo a Passo de como rodar o programa em Swagger
 1. Passo: Verificar se o MongoDB e Java está instalado na maquina.  
 2. Passo: Abrir a pasta em um Idea para Rodar o Java(Exemplo: Eclipse, Intellij).  
 3. Passo: Rodar o Main.java.  
 4. Passo: Abrir o localhost:8090/api-docs     
 5. Passo: Primerio tem que cadastrar um usuario.
 6. Passo: Depois de cadastrado vai em Credential-controller para gerar um token.
 7. Passo: Copiando o Token coloque ele em Available authorizations(cadeado em qualquer operação do CRUD).
 8. Passo: Quando for fazer algum CRUD coloque o Token em Authorization 

  ## Passo a Passo de como rodar o programa em Postman
 1. Passo: Verificar se o MongoDB e Java está instalado na maquina.  
 2. Passo: Abrir a pasta em um Idea para Rodar o Java(Exemplo: Eclipse, Intellij).  
 3. Passo: Rodar o Main.java.  
 4. Passo: Abrir o postman e no lugar colocar o post e cadastrar um usuario e senha no http://localhost:8090/projeto/api/v1/cadastro.     
 5. Passo: Depois de castratar colocar a url http://localhost:8090/projeto/api/v1/login e gerar um token enviando o usuario e senha cadastrados.
 6. Passo: Depois copiar o token gerado.
 7. Passo: Quando for acessar alguma A API de animal,servico ou pessoa vai em Authorization no type coloque o Bearer Token e adicione o token.
 8. Passo: Agora pode fazer o CRUD pois esta autorizado.

Exemplo com imagem:

![image](https://github.com/user-attachments/assets/d1cc3ac3-faf7-45e5-9154-d8c5e65faa09)


![image](https://github.com/user-attachments/assets/f2f35582-497c-408e-8772-951f04a33010)


