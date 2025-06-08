package com.example.migration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MigrationApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testApiEndpoint() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-USER", "test-user");
		HttpEntity<String> entity = new HttpEntity<>(headers);

		ResponseEntity<String> response = restTemplate.exchange(
				"/api", HttpMethod.GET, entity, String.class);

		assertEquals("Migrated one user from SQL to MongoDB successfully!", response.getBody());
		assertEquals(200, response.getStatusCode().value());
	}

	@Test
	void testInvalidEndpoint() {
		ResponseEntity<String> response = restTemplate.getForEntity("/invalid", String.class);

		assertEquals(404, response.getStatusCode().value());
	}
}
