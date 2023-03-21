package components;
import interfaces.Musician;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Qualifier("trombone")
@Component("trombone")

public class Trombonist implements Musician {
    @Override
    public void doMusic() {
        System.out.println("Trombone sounds");
    }
}
