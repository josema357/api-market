## Rest API | Market | Spring Boot

### Technology used
* [`Spring Web`](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)
* [`Spring Data JPA`](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa)
* [`Flyway`](https://mvnrepository.com/artifact/org.flywaydb/flyway-core)
* [`Postgresql`](https://mvnrepository.com/artifact/org.postgresql/postgresql)
* [`MapStruct`](https://mapstruct.org/)
* [`Lombok`](https://projectlombok.org/)
### Project description
This project is part of platzi course "Curso de Java Spring". Rest API with Spring for market.
<br>
Entities:<br>
`clientes`<br>
`productos`<br>
`categorias`<br>
`compras`<br>
`compras_productos`<br>

### BD diagram

<img src="./src/main/resources/static/db_diagram.png" alt=""/>

### Build

- Build executable jar: `./gradlew bootJar`
- Check jar file: `PORT=4000 DB_URL=jdbc:postgresql://localhost:5432/api-market DB_USERNAME=postgres DB_PASSWORD=yourpassword  java -jar -Dspring.profiles.active=pdn build/libs/market-1.0.0.jar`

