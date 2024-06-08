<div align="center">
<img src="https://github.com/FelipeAraujo32/Authentication-Authorization/assets/136930797/844eb032-4ba9-4f80-a38a-9dd570003e2c" width="600px ">
 
# 🔐 Sistema de Autenticação com Spring Security e Token 🔑

Este projeto é um exemplo de um sistema de autenticação desenvolvido em Java utilizando Spring Security. O sistema permite a criação e validação de usuários por meio de tokens.
</div>

## 🔨 Funcionalidades do projeto
- `Registro de novos usuários:` Permita que novos usuários se registrem na plataforma, fornecendo informações básicas como nome, e-mail e senha.
- `Geração de tokens para autenticação:` Após o registro, os usuários podem solicitar tokens de autenticação únicos, que serão utilizados para acessar recursos protegidos da aplicação.
- `Validação de tokens para acesso seguro às rotas protegidas:`Os tokens gerados são validados pelo sistema para garantir a autenticidade do usuário e fornecer acesso seguro às rotas protegidas.
- `Gerenciamento de Sessões:` A aplicação controla as sessões dos usuários de forma eficiente, permitindo uma experiência segura e consistente durante a interação com a plataforma.
- `Proteção de Rotas:` Determinadas rotas da aplicação são protegidas e só podem ser acessadas por usuários autenticados com tokens válidos, garantindo a segurança dos dados e das operações realizadas.
- `Customização de Permissões:` O sistema oferece a capacidade de atribuir diferentes níveis de permissões aos usuários, permitindo o acesso controlado a diferentes partes da aplicação com base em seus papéis e autorizações.

## Pré-requisitos
- Java JDK 17 
- Maven

## 🛠️ Instalação e Configuração
1. Clone este repositório:
   ``` git clone https://github.com/FelipeAraujo32/Authentication-Authorization.git ```
2. Navegue até o diretório do projeto:
   ``` cd Authentication-Authorization ```
3. Construa o projeto utilizando o Maven:
   ``` mvn clean install ```
4. Execute a aplicação:
    ``` mvn spring-boot:run  ```
5. Acesse a aplicação em http://localhost:8080.

## Uso
- Para se registrar como um novo usuário, acesse http://localhost:8080/register e preencha o formulário.
- Após o registro, faça login em http://localhost:8080/login para gerar um token de autenticação.
- Utilize o token gerado para acessar rotas protegidas da aplicação.

## ✔️ Tecnologias Utilizadas
- Java
- Spring Boot
- Spring Security

# Autor 👦
| [<img loading="lazy" src="https://avatars.githubusercontent.com/u/136930797?v=4" width=150><br><sub>Felipe Araujo</sub>](https://github.com/FelipeAraujo32)
| :---: |

## 🔸 Contribuindo
Contribuições são bem-vindas! Sinta-se à vontade para abrir um problema ou enviar um pull request.
## 🔸 Licença
Este projeto é licenciado sob a MIT License.
