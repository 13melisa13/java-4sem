package application;

import components.Kostya;
import config.BeanConfig;
import interfaces.Musician;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        try {
            for (String s: context.getBeanDefinitionNames())
                System.out.println(s);

            Kostya kostya =  new Kostya(context.getBean(args[0], Musician.class));
            kostya.music();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.err.println("Expected 1 command line argument");
        }

    }
}
