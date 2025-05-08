package com.example.migration;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreadSafetyTests {

    private static final String BASE_URL = "http://localhost:8081/employee/profile";

    @Test
    public void testConcurrentAccessToUserController() throws InterruptedException {
        int threadCount = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        RestTemplate restTemplate = new RestTemplate();

        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL, String.class);
                assertEquals("Migrated one user from SQL to MongoDB successfully!", response.getBody());
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
