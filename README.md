# Projeto bestminds - README

## Tecnologias Utilizadas

### Backend (Spring Boot)
- **Spring Boot**: 3.3.3
- **Spring Data JPA**: 3.3.3
- **Hibernate Core**: 6.5.2.Final
- **Jakarta Persistence API**: 3.1.0
- **Jakarta Transaction API**: 2.0.1
- **PostgreSQL JDBC Driver**: 42.7.3
- **JUnit**: 5.10.3
- **Mockito**: 5.11.0

### Frontend (Angular)
- **Node.js**: 20.12.2
- **npm**: 10.5.0
- **Angular CLI**: 17.3.8
- **Angular Framework**: 17.3.12
- **TypeScript**: 5.3.3
- **RxJS**: 7.8.1
- **Zone.js**: 0.14.10

### Outras Dependências
- **AspectJ Weaver**: 1.9.22.1
- **HikariCP**: 5.1.0
- **JBoss Logging**: 3.5.3.Final
- **Jackson Databind**: 2.17.2
- **Jackson Annotations**: 2.17.2
- **SLF4J API**: 2.0.16
- **Logback Classic**: 1.5.7
- **Tomcat Embed Core**: 10.1.28
- **Spring Web**: 6.1.12
- **Micrometer Observation**: 1.13.3

## Instalação

### Requisitos
- Node.js v20.12.2 ou superior
- npm v10.5.0 ou superior
- Angular CLI v17.3.8 ou superior
- Java JDK 17 ou superior
- Maven 3.8 ou superior

### Passos para Instalação
1. Clone o repositório:
   ```bash
   git clone https://github.com/Jose-Luan-Fabro-Kaupka/Best_minds
   cd projeto-produtos

2. Instale as dependências do frontend:
    ```bash
    cd frontend
    npm install

3. Instale as dependências do backend:
    ```bash
    cd backend
    mvn clean install

4. Configure o banco de dados no arquivo application.properties (Spring Boot).

### Uso
1. Inicie o backend:
    ```bash
    cd produtos
    mvn spring-boot:run

2. Inicie o frontend:
    ```bash
    cd bestminds_front
    ng serve

3. Acesse a aplicação no navegador: http://localhost:4200
