# Important Methods and Annotations

This document focuses on practical methods and annotations you see in this backend.
Every section includes references to official documentation.

## Controller Methods 

### `getAll()`
Typical purpose: return all resources of one type.
In REST APIs, this is usually mapped with `@GetMapping`.

**Sources:**
- Spring MVC `@GetMapping`: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/GetMapping.html
- MDN HTTP `GET`: https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/GET

### `getById(UUID id)`
Returns one resource by identifier.
The ID often comes from a URL segment using `@PathVariable`.

**Sources:**
- Spring `@PathVariable`: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/PathVariable.html
- MDN URL path concepts: https://developer.mozilla.org/en-US/docs/Learn/Common_questions/Web_mechanics/What_is_a_URL

### `create(@RequestBody DTO dto)`
Creates a new resource from JSON body data.
`@RequestBody` tells Spring to deserialize JSON into a Java object.

**Sources:**
- Spring `@RequestBody`: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestBody.html
- MDN HTTP `POST`: https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/POST

### `deleteById(UUID id)`
Deletes one resource.
Usually mapped with `@DeleteMapping` in REST controllers.

**Sources:**
- Spring `@DeleteMapping`: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/DeleteMapping.html
- MDN HTTP `DELETE`: https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/DELETE

## Service Methods 

### `getAll()`, `getById(...)`, `create(...)`, `deleteById(...)`
In a layered architecture, these methods orchestrate business logic and delegate data access to repositories.

**Sources:**
- Fowler Service Layer pattern: https://martinfowler.com/eaaCatalog/serviceLayer.html
- Spring `@Service`: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Service.html

## Repository Methods 

### `findAll()`
Returns all rows/entities.
Provided by Spring Data repository interfaces.

**Sources:**
- Spring Data repositories: https://docs.spring.io/spring-data/jpa/reference/repositories.html

### `findById(ID id)`
Returns `Optional<T>` because data may be absent.

**Sources:**
- Spring Data CrudRepository API (`findById`): https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
- Java `Optional`: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Optional.html

### `save(T entity)`
Inserts or updates an entity, depending on persistence context and entity identity.

**Sources:**
- Spring Data CrudRepository API (`save`): https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html

### `delete(T entity)`
Removes the given entity from persistent storage.

**Sources:**
- Spring Data CrudRepository API (`delete`): https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html

### Derived query methods (example: `findByEmail(String email)`)
Spring Data can derive query behavior from method names.
This avoids writing boilerplate SQL/JPQL for simple conditions.

**Sources:**
- Spring Data JPA query method keywords: https://docs.spring.io/spring-data/jpa/reference/repositories/query-keywords-reference.html
- Query creation from method names: https://docs.spring.io/spring-data/jpa/reference/repositories/query-methods-details.html

## Factory Methods

### `fromUserDTO(RegistrationDTO dto)`, `fromTeacherDTO(...)`, `fromDTO(CourseDTO dto)`
These methods convert incoming API DTOs into entity objects.
Centralizing this mapping avoids duplication and keeps transformation rules consistent.

**Sources:**
- Factory Method pattern overview: https://refactoring.guru/design-patterns/factory-method
- Fowler DTO pattern: https://martinfowler.com/eaaCatalog/dataTransferObject.html

## Common Java Methods in Entities/DTOs

### Getter methods (`getXyz()`)
Return field values. Commonly used by Java frameworks for reflection and serialization.

**Sources:**
- JavaBeans property conventions: https://docs.oracle.com/javase/tutorial/javabeans/writing/properties.html

### Setter methods (`setXyz(...)`)
Assign field values and are frequently used for data binding.

**Sources:**
- JavaBeans property conventions: https://docs.oracle.com/javase/tutorial/javabeans/writing/properties.html

### `toString()`
Returns a textual representation of an object. Useful for diagnostics and debugging.

**Sources:**
- Java API (`Object.toString()`): https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Object.html#toString()

## Core Spring and JPA Annotations

### `@SpringBootApplication`
Enables auto-configuration, component scanning, and additional Spring Boot behavior.

**Sources:**
- Spring Boot reference: https://docs.spring.io/spring-boot/reference/using/using-the-springbootapplication-annotation.html

### `@RestController`
Marks a class as a REST controller where return values are written to the HTTP response body.

**Sources:**
- Spring API docs: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RestController.html

### `@RequestMapping`
Maps web requests to classes and methods.

**Sources:**
- Spring API docs: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestMapping.html

### `@GetMapping`, `@PostMapping`, `@DeleteMapping`
Shortcut annotations for request mapping by HTTP method.

**Sources:**
- `@GetMapping`: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/GetMapping.html
- `@PostMapping`: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/PostMapping.html
- `@DeleteMapping`: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/DeleteMapping.html

### `@PathVariable`
Binds URI template variables to method parameters.

**Sources:**
- Spring API docs: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/PathVariable.html

### `@RequestBody`
Binds request body to a method parameter using HTTP message converters.

**Sources:**
- Spring API docs: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestBody.html

### `@Service`
Stereotype annotation for service-layer components.

**Sources:**
- Spring API docs: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Service.html

### `@Repository`
Stereotype annotation for persistence-layer components and exception translation support.

**Sources:**
- Spring API docs: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Repository.html

### `@Entity`
Declares a JPA entity.

**Sources:**
- Jakarta Persistence API docs: https://jakarta.ee/specifications/persistence/

### `@Table`
Specifies primary table mapping details.

**Sources:**
- Jakarta Persistence annotation docs (`Table`): https://jakarta.ee/specifications/persistence/3.1/apidocs/jakarta.persistence/jakarta/persistence/table

### `@Id`
Declares primary key field.

**Sources:**
- Jakarta Persistence annotation docs (`Id`): https://jakarta.ee/specifications/persistence/3.1/apidocs/jakarta.persistence/jakarta/persistence/id

### `@GeneratedValue`
Declares primary key generation strategy.

**Sources:**
- Jakarta Persistence annotation docs (`GeneratedValue`): https://jakarta.ee/specifications/persistence/3.1/apidocs/jakarta.persistence/jakarta/persistence/generatedvalue

### `@Column`
Maps a field/property to a table column.

**Sources:**
- Jakarta Persistence annotation docs (`Column`): https://jakarta.ee/specifications/persistence/3.1/apidocs/jakarta.persistence/jakarta/persistence/column

### `@ManyToOne`, `@OneToMany`, `@ManyToMany`
Declare cardinality relationships between entities.

**Sources:**
- Jakarta Persistence relationship mappings: https://jakarta.ee/specifications/persistence/

### `@JoinColumn`, `@JoinTable`
Define how relationships are represented in relational tables.

**Sources:**
- Jakarta Persistence annotation docs (`JoinColumn`): https://jakarta.ee/specifications/persistence/3.1/apidocs/jakarta.persistence/jakarta/persistence/joincolumn
- Jakarta Persistence annotation docs (`JoinTable`): https://jakarta.ee/specifications/persistence/3.1/apidocs/jakarta.persistence/jakarta/persistence/jointable

### `@NotBlank`, `@NotNull`
Validation constraints used for input/data model validation.

**Sources:**
- Jakarta Bean Validation specification: https://beanvalidation.org/
- Hibernate Validator reference: https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/

### `@Configuration` and `@Bean`
Define Spring configuration classes and bean-producing methods.

**Sources:**
- Spring Java-based configuration: https://docs.spring.io/spring-framework/reference/core/beans/java.html

## Security Configuration Methods

### `securityFilterChain(HttpSecurity http)`
Defines Spring Security behavior for incoming requests (authorization, csrf, etc.).

**Sources:**
- Spring Security reference: https://docs.spring.io/spring-security/reference/servlet/architecture.html
- Spring Security Java configuration: https://docs.spring.io/spring-security/reference/servlet/configuration/java.html

### `corsConfigurationSource()`
Creates CORS configuration rules for allowed origins/methods/headers.

**Sources:**
- Spring Framework CORS support: https://docs.spring.io/spring-framework/reference/web/webmvc-cors.html
- MDN CORS overview: https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS
