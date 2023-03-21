package com.example.task11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Task11Application {

    public static void main(String[] args) {
        SpringApplication.run(Task11Application.class, args);
    }
    // http://localhost:8080/actuator/health
    // java -jar build/libs/task11-0.0.1-SNAPSHOT-plain.jar
}
