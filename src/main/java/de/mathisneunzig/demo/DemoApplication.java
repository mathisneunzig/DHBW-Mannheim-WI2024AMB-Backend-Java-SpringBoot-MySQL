package de.mathisneunzig.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application entry point.
 *
 * <p>{@link SpringBootApplication} triggers component scanning and auto-configuration,
 * so Spring discovers controllers, services, repositories, and configuration classes
 * without manual wiring.
 */
@SpringBootApplication
public class DemoApplication {

	/**
	 * Starts the embedded application server and initializes the Spring context.
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
