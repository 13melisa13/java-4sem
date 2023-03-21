package components;

import interfaces.Musician;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Qualifier("guitar")
@Component("guitar")
public class Guitarist implements Musician {
    @Override
    public void doMusic() {
        System.out.println("Guitar sounds");
    }
}
