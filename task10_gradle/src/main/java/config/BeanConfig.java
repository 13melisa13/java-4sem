package config;

import components.Drummer;
import components.Guitarist;
import components.Kostya;
import components.Trombonist;
import interfaces.Musician;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class BeanConfig {
    @Bean
    Musician guitar(){
        return new Guitarist();
    }
    @Bean
    Musician drum(){
        return new Drummer();
    }
    @Bean
    Musician trombone(){
        return new Trombonist();
    }

}