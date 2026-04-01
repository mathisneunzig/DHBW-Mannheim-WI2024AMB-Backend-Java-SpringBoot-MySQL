package de.mathisneunzig.demo.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * Central Spring Security setup.
 *
 * <p>This demo keeps all routes open ({@code permitAll()}) to make onboarding easier.
 * In production, replace this with endpoint-specific authorization rules and
 * authentication (JWT/session/etc.).
 */
@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		  .cors(Customizer.withDefaults())
          // Disabled because many demos use stateless APIs; for browser form apps, CSRF should be enabled.
		  .csrf(csrf -> csrf.disable())
		  .authorizeHttpRequests(auth -> auth
		    .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
		    .anyRequest().permitAll()
		  )
		  .httpBasic(b -> b.disable())
		  .formLogin(f -> f.disable())
		  .logout(l -> l.disable());

		return http.build();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration config = new CorsConfiguration();

	    config.setAllowedOrigins(getAllowedOrigins());
		config.setAllowedMethods(getAllowedMethods());
		config.setAllowedHeaders(getAllowedHeaders());
		config.setAllowCredentials(false);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
	    return source;
	}

	private List<String> getAllowedOrigins() {
		return Arrays.asList("*");
	}

	private List<String> getAllowedMethods() {
		return Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "TRACE", "HEAD");
	}

	private List<String> getAllowedHeaders() {
		return Arrays.asList("*");
	}
}
