# 📦 Sistema de Controle de Estoque Full Stack

Projeto desenvolvido como parte dos estudos de **Engenharia de Software na UTFPR**. O sistema evoluiu de uma aplicação simples de console para uma arquitetura distribuída com **API REST** em Java, persistência em **PostgreSQL** e interface web moderna.

---

## 🚀 Status do Projeto: Em Desenvolvimento (Fase de Integração)

Atualmente, o sistema já realiza a comunicação completa entre as camadas. O back-end lê e salva dados no banco de dados e os expõe via JSON para que o front-end os exiba em um dashboard dinâmico.

---

## 🛠️ Tecnologias Utilizadas

### **Back-end**
*   **Java 25**: Linguagem principal.
*   **Spring Boot 3.2.5**: Framework para criação da API REST.
*   **Spring Data JPA**: Para abstração da camada de dados.
*   **PostgreSQL 18**: Banco de dados relacional para persistência.
*   **Maven**: Gerenciador de dependências.

### **Front-end**
*   **HTML5 & CSS3**: Estrutura e estilização (estética Dark/Cinematic).
*   **JavaScript (Vanilla)**: Consumo da API via Fetch API e manipulação do DOM.

---

## 📂 Estrutura do Repositório

O repositório segue o padrão **Monorepo**:

*   `/backend`: Contém o código-fonte do servidor Spring Boot, configurações de banco de dados e lógica de negócio.
*   `/frontend`: Contém a interface do usuário, incluindo o dashboard de visualização do estoque.

---

## 🔧 Como Executar o Projeto

### 1. Pré-requisitos
*   Java JDK 17+ instalado.
*   PostgreSQL 18 instalado e rodando.
*   IDE de sua preferência (IntelliJ recomendado para o back-end e VS Code para o front-end).

### 2. Configuração do Banco de Dados
Certifique-se de criar um banco de dados chamado `sistema_estoque` no Postgres e configurar as credenciais no arquivo:
`backend/src/main/resources/application.properties`

### 3. Rodando o Back-end
1. Abra a pasta `backend` no IntelliJ.
2. Aguarde o Maven baixar as dependências.
3. Execute a classe `Main`. A API estará disponível em `http://localhost:8080/api/produtos`.

### 4. Rodando o Front-end
1. Abra a pasta `frontend` no VS Code.
2. Com a extensão **Live Server**, abra o arquivo `index.html`.
3. O dashboard carregará automaticamente os produtos vindos do banco de dados.

---

## 📌 Próximos Passos
- [ ] Implementar a funcionalidade de adicionar novos itens diretamente pela interface web.
- [ ] Adicionar opções de edição e exclusão de produtos no dashboard.
- [ ] Refinar o design responsivo do front-end.

---
**Desenvolvido por [Otávio Abati](https://github.com/OtavioAbati)**
