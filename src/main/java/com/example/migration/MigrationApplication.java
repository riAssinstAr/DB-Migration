package com.example.migration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class MigrationApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.load();
		System.setProperty("SUPABASE_DB_URL", dotenv.get("SUPABASE_DB_URL"));
		System.setProperty("SUPABASE_DB_USER", dotenv.get("SUPABASE_DB_USER"));
		System.setProperty("SUPABASE_DB_PASS", dotenv.get("SUPABASE_DB_PASS"));

		SpringApplication.run(MigrationApplication.class, args);
	}

}
