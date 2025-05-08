package com.example.migration.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import com.example.migration.service.MigrationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    private MigrationService migrationService;

    @Override
    public boolean preHandle(@NonNull HttpServletRequest req, @NonNull HttpServletResponse res,
            @NonNull Object handler) {
        String username = req.getHeader("X-USER");
        logger.info("Intercepted request with X-USER header: " + username);
        if (username == null || username.isEmpty()) {
            logger.info("X-USER header is missing or empty.");
            return true;
        }
        migrationService.migrateIfNeeded(username);
        return true;
    }
}
