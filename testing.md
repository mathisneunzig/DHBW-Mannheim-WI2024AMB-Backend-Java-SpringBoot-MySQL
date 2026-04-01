# Testing Guide 

This project uses JUnit 5 + Spring Test support + Mockito + H2 for isolated tests.

## 1) Test strategy in this project

We use multiple test layers because each layer answers a different question:

1. **Unit tests** (fast, isolated)
   - Example: factory/service tests with Mockito mocks
   - Goal: verify business and mapping logic without starting full Spring context

2. **Web layer tests** (`@WebMvcTest`)
   - Goal: verify controller endpoint behavior and JSON/status handling
   - Dependencies such as services are mocked

4. **Smoke test** (`@SpringBootTest`)
   - Goal: verify the application context can start

## 2) H2 test database configuration

The file `src/test/resources/application-test.properties` configures H2:
- in-memory JDBC URL
- Hibernate `create-drop`
- H2 dialect
- no external MySQL required

This makes tests portable and CI-friendly.

## 3) How to run tests

### Run all tests
```bash
./mvnw test
```

### Run one test class
```bash
./mvnw -Dtest=UserServiceTest test
```

### Run with debug logs
```bash
./mvnw -X test
```

## 4) Test classes currently included

- `DemoApplicationTests` (context smoke test)
- `factories/*Test` (factory mapping tests)
- `service/*Test` (service orchestration tests)
- `controller/*Test` (`@WebMvcTest` web behavior tests)
- `repositories/*Test` (`@DataJpaTest` repository + mapping tests)

## 5) Why this matters for beginners

- You learn to test each architecture layer independently.
- Failures are easier to diagnose.
- Tests become faster and more maintainable.
- H2 helps you test DB interactions without setting up infrastructure.

## 6) Common testing annotations in this project

- `@SpringBootTest` - full context test
- `@WebMvcTest` - MVC slice test
- `@DataJpaTest` - repository slice test
- `@ActiveProfiles("test")` - use test config
- `@MockBean` / Mockito `@Mock` - mock dependencies

## Sources
- Spring Boot testing reference: https://docs.spring.io/spring-boot/reference/testing/
- Spring Framework testing reference: https://docs.spring.io/spring-framework/reference/testing/
- Spring Data JPA testing docs: https://docs.spring.io/spring-data/jpa/reference/jpa/testing.html
- H2 database docs: https://h2database.com/html/main.html
- JUnit 5 user guide: https://junit.org/junit5/docs/current/user-guide/
- Mockito docs: https://site.mockito.org/
