package components;

import interfaces.Musician;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Qualifier("drum")
@Component("drum")

public class Drummer implements Musician {
    @Override
    public void doMusic() {
        System.out.println("Drum sounds");
    }
}
