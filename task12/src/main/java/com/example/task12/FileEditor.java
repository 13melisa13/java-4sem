package com.example.task12;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileEditor {
    static BufferedWriter writer;
    static BufferedReader reader;
    static Path filePath;
    FileEditor(String... args) throws Exception{
        this.reader = new BufferedReader(new FileReader(args[0]));
        this.writer = new BufferedWriter(new FileWriter(args[1]));
        this.filePath = Paths.get(args[0]);
    }
    @PostConstruct
    public void init() throws IOException {
        int character;
        while((character = reader.read()) != -1) {
            writer.write(character);
        }
        reader.close();
        writer.close();
    }
    @PreDestroy
    public void destroy() throws IOException {
        Files.delete(filePath.toAbsolutePath());
    }

}
