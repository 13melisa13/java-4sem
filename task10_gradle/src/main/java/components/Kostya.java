package components;
import interfaces.Musician;
import org.springframework.stereotype.Component;

@Component
public class Kostya {
    private final Musician musician;

    public Kostya (Musician musician){
        this.musician = musician;
    }

    public void music(){
        System.out.println("Kostya: ");
        musician.doMusic();
    }
}
