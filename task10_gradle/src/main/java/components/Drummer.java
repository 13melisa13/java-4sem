package components;

import interfaces.Musician;
import org.springframework.stereotype.Component;
@Component
public class Drummer implements Musician {
    @Override
    public void doMusic() {
        System.out.println("Drum sounds");
    }
}
