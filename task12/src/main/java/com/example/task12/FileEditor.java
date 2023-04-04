package com.example.task12;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component ()
public class FileEditor {
    @Value("#{springApplicationArguments.nonOptionArgs[0]}")
    String path1;
    @Value("#{springApplicationArguments.nonOptionArgs[1]}")
    String path2;

    public static byte[] fromByteArrayToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        System.out.println("hashing");
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString().getBytes();
    }

    @PostConstruct
    public void init() throws IOException {
        System.out.println("PostConstruct");
        if (!Files.exists(Paths.get(path2)))
            path2 = "src\\main\\resources\\second.txt";
        if (!(Files.exists(Paths.get(path1))))
            Files.write(Path.of(path2),"null".getBytes());
        Files.write(Path.of(path2),fromByteArrayToHex(Files.readAllBytes(Path.of(path2))));
    }
    @PreDestroy
    public void destroy(){
        System.out.println("PreDestroy");
        try {
            Files.delete(Paths.get(path1).toAbsolutePath());
        } catch (Exception ignored){

        }
    }
}
