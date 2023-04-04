package com.example.task13_spring;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class StudentEnvironment {
    @Autowired
    Environment environment;
    @PostConstruct
    void init(){
        System.out.println(environment.getProperty("student.name") +
                environment.getProperty("student.last_name") +
                environment.getProperty("student.group") + "with Environment");
    }
}
