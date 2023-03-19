package components;

import interfaces.Musician;
import org.springframework.stereotype.Component;
@Component
public class Guitarist implements Musician {
    @Override
    public void doMusic() {
        System.out.println("Guitar sounds");
    }
}
