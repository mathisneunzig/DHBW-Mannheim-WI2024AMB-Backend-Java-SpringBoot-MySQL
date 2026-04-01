# Backend Glossary 

This glossary explains important terms that appear in this Spring Boot demo project.
All definitions below are aligned with official documentation or widely accepted standards references.

## API (Application Programming Interface)
An API is a defined interface that allows different software systems to communicate.
In web backends like this project, the API is usually exposed over HTTP.

**Sources:**
- MDN Web Docs, “Web APIs” and API fundamentals: https://developer.mozilla.org/en-US/docs/Learn_web_development/Extensions/Client-side_APIs/Introduction
- IBM, “What is an API?”: https://www.ibm.com/think/topics/api

## REST
REST (Representational State Transfer) is an architectural style for distributed systems.
In practice, RESTful HTTP APIs commonly use resources, URIs, and HTTP methods like `GET`, `POST`, `PUT`, and `DELETE`.

**Sources:**
- Roy Fielding dissertation (original REST definition): https://www.ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm
- Red Hat, “What is a REST API?”: https://www.redhat.com/en/topics/api/what-is-a-rest-api

## Endpoint
An endpoint is a specific network location where an API can be accessed, usually described as HTTP method + URL path.
Example: `GET /users`.

**Sources:**
- Postman Learning Center, API basics/endpoints: https://learning.postman.com/docs/getting-started/introduction/
- MDN HTTP overview: https://developer.mozilla.org/en-US/docs/Web/HTTP/Overview

## Controller
In Spring MVC/Spring Web, a controller handles incoming HTTP requests and returns responses.
It is part of the web layer and should focus on transport concerns (request mapping, status codes, serialization).

**Sources:**
- Spring Framework reference, “Annotated Controllers”: https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller.html

## Service
A service class typically contains business logic and coordinates use-cases.
This is a software architecture convention in layered applications and is strongly encouraged for separation of concerns.

**Sources:**
- Martin Fowler, “Service Layer” pattern: https://martinfowler.com/eaaCatalog/serviceLayer.html
- Spring stereotype annotations (`@Service`): https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Service.html

## Repository
A repository abstracts data access and collection-like operations for domain objects.
In Spring Data, repositories are interfaces and implementations are often generated automatically.

**Sources:**
- Martin Fowler, “Repository” pattern: https://martinfowler.com/eaaCatalog/repository.html
- Spring Data JPA repositories: https://docs.spring.io/spring-data/jpa/reference/repositories.html

## JpaRepository
`JpaRepository` is a Spring Data interface that extends repository capabilities with JPA-specific CRUD, paging, and sorting functionality.

**Sources:**
- Spring Data JPA reference: https://docs.spring.io/spring-data/jpa/reference/jpa/repositories.html
- API docs (`JpaRepository`): https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html

## Entity
A JPA entity is a lightweight persistent domain object that is mapped to a database table.
Entity mapping is configured with annotations like `@Entity`, `@Table`, `@Id`, etc.

**Sources:**
- Jakarta Persistence specification project: https://jakarta.ee/specifications/persistence/
- Oracle Java EE tutorial (JPA entities): https://docs.oracle.com/javaee/7/tutorial/persistence-intro.htm

## DTO (Data Transfer Object)
A DTO is an object used to transfer structured data between layers/processes without exposing full domain internals.
DTOs are commonly used for API request/response payloads.

**Sources:**
- Martin Fowler, “Data Transfer Object”: https://martinfowler.com/eaaCatalog/dataTransferObject.html
- Microsoft architecture guidance (DTO usage in APIs): https://learn.microsoft.com/en-us/azure/architecture/best-practices/api-design

## Factory (Factory Pattern)
A factory encapsulates object creation logic.
This is useful when construction requires multiple steps, validation, mapping, or dependency lookups.

**Sources:**
- Refactoring.Guru, Factory Method pattern: https://refactoring.guru/design-patterns/factory-method
- GoF design patterns summary (widely used reference): https://en.wikipedia.org/wiki/Factory_method_pattern

## Dependency Injection
Dependency Injection means an object receives required dependencies from an external container/framework instead of constructing them itself.
Spring’s IoC container supports this through constructor/field/setter injection.

**Sources:**
- Spring Core, IoC container: https://docs.spring.io/spring-framework/reference/core/beans/introduction.html
- Martin Fowler, “Inversion of Control Containers and DI”: https://martinfowler.com/articles/injection.html

## Class
A class is a fundamental building block in object-oriented programming.
It defines the structure (fields) and behavior (methods) of objects created from it.
In Spring Boot projects, classes are used for controllers, services, entities, DTOs, configurations, and more.

**Sources:**
- Oracle Java Language Specification, Classes: https://docs.oracle.com/javase/specs/jls/se17/html/jls-8.html
- Oracle Java Tutorials, Classes and Objects: https://docs.oracle.com/javase/tutorial/java/javaOO/

## Interface
An interface defines a contract of methods that a class can implement, without providing concrete behavior (except for default/static methods).
Interfaces are heavily used in Spring for loose coupling, testability, and framework-generated implementations (e.g. repositories).

**Sources:**
- Oracle Java Language Specification, Interfaces: https://docs.oracle.com/javase/specs/jls/se17/html/jls-9.html
- Spring Framework reference, core concepts: https://docs.spring.io/spring-framework/reference/core.html

## Enum
An enum (enumeration) is a special Java type used to define a fixed set of constant values.
Enums improve type safety and readability compared to using plain constants, and are often used for statuses, roles, or categories.

**Sources:**
- Oracle Java Tutorials, Enum Types: https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
- Java SE API docs (`java.lang.Enum`): https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Enum.html

## Annotation
A Java annotation is metadata added to code elements and processed at compile-time or runtime.
Spring and JPA rely heavily on annotations for configuration.

**Sources:**
- Oracle Java annotations tutorial: https://docs.oracle.com/javase/tutorial/java/annotations/

## Security Filter Chain
In Spring Security, request processing is handled by a chain of filters.
`SecurityFilterChain` configures authentication, authorization, CSRF, CORS, etc.

**Sources:**
- Spring Security reference: https://docs.spring.io/spring-security/reference/servlet/architecture.html
- API docs (`SecurityFilterChain`): https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/web/SecurityFilterChain.html

## CORS
CORS (Cross-Origin Resource Sharing) is a browser security mechanism based on HTTP headers that controls whether frontend code from one origin can access another origin.

**Sources:**
- MDN CORS guide: https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS
- Fetch standard (CORS protocol): https://fetch.spec.whatwg.org/

## CSRF
CSRF (Cross-Site Request Forgery) is an attack where a user’s browser is tricked into sending unwanted authenticated requests.
Frameworks often provide CSRF protection for cookie/session-based auth.

**Sources:**
- OWASP CSRF overview: https://owasp.org/www-community/attacks/csrf
- Spring Security CSRF docs: https://docs.spring.io/spring-security/reference/servlet/exploits/csrf.html

## Maven / pom.xml
Maven is a build automation and dependency management tool for Java.
`pom.xml` is the project descriptor containing metadata, dependencies, plugins, and build settings.

**Sources:**
- Apache Maven official docs: https://maven.apache.org/guides/getting-started/
- POM reference: https://maven.apache.org/pom.html

## Getter and Setter
Getters and setters are accessor and mutator methods used to encapsulate fields.
They are part of JavaBeans conventions, which many frameworks use for reflection and data binding.

**Sources:**
- Oracle JavaBeans conventions (tutorial): https://docs.oracle.com/javase/tutorial/javabeans/writing/properties.html

## `toString()`
`toString()` is a method inherited from `java.lang.Object` that returns a string representation of an object.
It is useful for debugging/logging but should avoid exposing sensitive data.

**Sources:**
- Java SE API docs (`Object.toString()`): https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Object.html#toString()
- OWASP Logging Cheat Sheet (sensitive data caution): https://cheatsheetseries.owasp.org/cheatsheets/Logging_Cheat_Sheet.html

## SOLID Principles
SOLID is a set of five object-oriented design principles: Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, and Dependency Inversion.
They help create code that is easier to maintain, test, and extend.

**Sources:**
- Robert C. Martin (overview and principle definitions): https://en.wikipedia.org/wiki/SOLID
- Martin Fowler, design principles context: https://martinfowler.com/bliki/DesignPrinciplesAndDesignPatterns.html

## Design Pattern
A design pattern is a reusable solution template for common software design problems.
Patterns are not copy-paste code; they are communication and design vocabulary.

**Sources:**
- Refactoring.Guru pattern catalog: https://refactoring.guru/design-patterns
- Gang of Four summary: https://en.wikipedia.org/wiki/Design_Patterns

## Software Architecture
Software architecture describes the high-level structure of a system, its components, and how they interact.
Layered architecture (controller/service/repository) is one common backend style.

**Sources:**
- ISO/IEC/IEEE 42010 overview: https://en.wikipedia.org/wiki/ISO/IEC/IEEE_42010
- Martin Fowler, architecture guide: https://martinfowler.com/architecture/

## Coding Standards / Coding Rules
Coding standards are agreed rules for naming, formatting, structure, and quality practices.
They improve readability, consistency, and maintainability across teams.

**Sources:**
- Oracle Java Code Conventions (historical baseline): https://www.oracle.com/java/technologies/javase/codeconventions-introduction.html
- Google Java Style Guide: https://google.github.io/styleguide/javaguide.html

## Command-Line Command
A command is an instruction executed in a shell (for example `mvn test` or `./mvnw spring-boot:run`).
Reliable development workflows often document frequently used commands in project docs.

**Sources:**
- GNU Bash manual: https://www.gnu.org/software/bash/manual/bash.html
- Apache Maven command line reference: https://maven.apache.org/ref/current/maven-embedder/cli.html
