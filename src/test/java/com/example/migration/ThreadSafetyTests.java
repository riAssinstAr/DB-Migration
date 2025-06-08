package com.example.migration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@SpringBootTest
class ThreadSafetyTests {

    private static final String BASE_URL = "http://localhost:8081/api";

    @Test
    public void testConcurrentAccessToUserController() throws InterruptedException {
        int threadCount = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        RestTemplate restTemplate = new RestTemplate();

        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                HttpHeaders headers = new HttpHeaders();
                headers.set("X-USER", "test-user");
                HttpEntity<String> entity = new HttpEntity<>(headers);

                ResponseEntity<String> response = restTemplate.exchange(
                        BASE_URL, HttpMethod.GET, entity, String.class);

                assertEquals("Migrated one user from SQL to MongoDB successfully!", response.getBody());
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
