package com.projects.mocker.config;

import org.springframework.context.annotation.Configuration;
import io.github.cdimascio.dotenv.Dotenv;

@Configuration
public class DotEnvConfig {

    public DotEnvConfig() {
        Dotenv dotenv = Dotenv.load();

        System.setProperty("MONGO_USERNAME", dotenv.get("MONGO_USERNAME"));
        System.setProperty("MONGO_PASSWORD", dotenv.get("MONGO_PASSWORD"));
        System.setProperty("MONGO_HOST", dotenv.get("MONGO_HOST"));
        System.setProperty("MONGO_PORT", dotenv.get("MONGO_PORT"));
        System.setProperty("MONGO_DATABASE", dotenv.get("MONGO_DATABASE"));

    }
}