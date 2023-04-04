package com.example.task13_spring;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StudentValue {
    @Value("${student.name}")
    private String name;
    @Value("${student.last_name}")
    private String last_name;
    @Value("${student.group}")
    private String group;
    @PostConstruct
    void init(){
        System.out.println(name + last_name + group + "with Value annotaion");
    }
}
