package com.example.migration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MigrationApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void testProfileEndpoint() {
		ResponseEntity<String> response = restTemplate.getForEntity("/employee/profile", String.class);
		assertEquals("Migrated one user from SQL to MongoDB successfully!", response.getBody());
		assertEquals(200, response.getStatusCode().value());
	}

	@Test
	void testInvalidEndpoint() {
		ResponseEntity<String> response = restTemplate.getForEntity("/employee/invalid", String.class);
		assertEquals(404, response.getStatusCode().value());
	}
}
