package com.example.migration.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.migration.service.MigrationService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired private MigrationService migrationService;

    @Override
    public boolean preHandle(@NonNull HttpServletRequest req, @NonNull HttpServletResponse res, @NonNull Object handler) {
        String username = req.getHeader("X-USER");
        System.out.println("Intercepted request with X-USER header: " + username);
        if (username == null || username.isEmpty()) {
            System.out.println("X-USER header is missing or empty.");
            return true;
        }
        migrationService.migrateIfNeeded(username);
        return true;
    }
}
