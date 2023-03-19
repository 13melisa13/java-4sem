package components;

import interfaces.Musician;
import org.springframework.stereotype.Component;
@Component
public class Trombonist implements Musician {
    @Override
    public void doMusic() {
        System.out.println("Trombone sounds");
    }
}
