package com.example.migration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class MigrationApplication {

	public static void main(String[] args) {

		// Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		// System.setProperty("SUPABASE_HOST", dotenv.get("SUPABASE_HOST"));
		// System.setProperty("SUPABASE_PORT", dotenv.get("SUPABASE_PORT"));
		// System.setProperty("SUPABASE_DB_USER", dotenv.get("SUPABASE_DB_USER"));
		// System.setProperty("SUPABASE_DB_PASS", dotenv.get("SUPABASE_DB_PASS"));

		// System.setProperty("MONGODB_USER", dotenv.get("MONGODB_USER"));
		// System.setProperty("MONGODB_PASS", dotenv.get("MONGODB_PASS"));

		SpringApplication.run(MigrationApplication.class, args);
	}

}
