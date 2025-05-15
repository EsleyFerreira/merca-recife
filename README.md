# Merca Recife

Merca Recife é uma API Java Spring Boot para gerenciamento de comerciantes, mercados e boxes. O sistema permite que comerciantes se cadastrem, selecionem mercados e reservem boxes disponíveis. O projeto utiliza Docker Compose para facilitar a configuração e inclui versionamento de banco de dados com Flyway.

## Tecnologias

### Back-end
- Java 21
- Spring Boot
    - Spring Web
    - Spring Data JPA
    - PostgresSQL Driver

- Docker Compose
- PostgreSQL
- Flyway
- Maven

## Getting Started

### Prerequisites

- Java 21+
- Maven
- Docker & Docker Compose

### Running Locally

1. **Clone the repository:**
   ```sh
   git clone https://github.com/EsleyFerreira/merca-recife
   cd merca-recife
    ```
   
### Start the database with Docker Compose

*Docker Run*
```sh
  docker-compose up -d
```

**Run the application:**


   ```sh
     mvn spring-boot:run
   ```
   
The API will be available at http://localhost:8080


Database Migrations
Flyway automatically runs migrations located in src/main/resources/db/migration on application startup.

