package com.example.task12;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class Task12Application implements CommandLineRunner {


    public static void main(String[] args)  throws Exception{
        SpringApplication.run(Task12Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


    }
}
