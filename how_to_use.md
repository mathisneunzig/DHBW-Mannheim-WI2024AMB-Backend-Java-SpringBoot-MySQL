# How to Use This Spring Boot Demo

This guide explains how to install prerequisites, configure the application, run it locally, and host it.
It is written for beginners.

## 1) Prerequisites

You need the following software:

1. **Java 17**
2. **Maven** (or use the Maven Wrapper `mvnw` included in this repository)
3. **MySQL** (for local/dev runtime), or H2 for quick testing
4. (Optional) **Git** and an IDE (IntelliJ IDEA, Eclipse, VS Code)

### Verify installation
```bash
java -version
mvn -version
```

If Maven is not installed globally, use:
```bash
./mvnw -version
```

## 2) Clone and install dependencies

```bash
git clone <your-repo-url>
cd DHBW-Demo-Backend-Java-SpringBoot-MySQL
./mvnw clean compile
```

This downloads dependencies and compiles the project.

## 3) Configure the application

Spring Boot usually reads configuration from `application.properties` or `application.yml`.
If you want to run against MySQL, create `src/main/resources/application.properties` with values similar to:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/demo
spring.datasource.username=demo_user
spring.datasource.password=demo_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Notes
- Use `create-drop` or `update` carefully.
- For production, do not store passwords in plaintext files. Use environment variables or secret managers.

## 4) Run the application

### Option A: Maven Wrapper (recommended)
```bash
./mvnw spring-boot:run
```

### Option B: Build JAR and run
```bash
./mvnw clean package
java -jar target/demo-1.0.0.jar
```

The server usually starts on `http://localhost:8080`.

## 5) Try API endpoints

Examples (using `curl`):

```bash
curl -X GET http://localhost:8080/users
curl -X GET http://localhost:8080/teachers
curl -X GET http://localhost:8080/courses
```

## 6) Hosting / Deployment basics

### Simple VM hosting
1. Install Java on server.
2. Copy JAR (`scp`).
3. Start with `java -jar`.
4. Use reverse proxy (Nginx) and process manager (systemd).

### Docker-based hosting (optional)
1. Create Dockerfile.
2. Build image.
3. Run container with environment variables for DB credentials.

### Cloud hosting options
- AWS (EC2, ECS, Elastic Beanstalk)
- Azure App Service / Container Apps
- Google Cloud Run / GKE

## 7) Configuration tips

- Keep separate profiles: `dev`, `test`, `prod`.
- Use `application-test.properties` for tests (already included under `src/test/resources`).
- Keep sensitive values outside source control.

## 8) Helpful commands quick list

```bash
./mvnw clean compile      # compile only
./mvnw test               # run tests
./mvnw clean package      # build jar
./mvnw spring-boot:run    # run app from source
```

## Sources
- Spring Boot reference docs: https://docs.spring.io/spring-boot/reference/
- Spring Boot Maven plugin docs: https://docs.spring.io/spring-boot/maven-plugin/
- Maven lifecycle docs: https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html
- MySQL Connector/J docs: https://dev.mysql.com/doc/connector-j/en/
- Docker docs: https://docs.docker.com/
