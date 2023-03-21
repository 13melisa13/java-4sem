package components;
import interfaces.Musician;



public class Kostya {
    private final Musician musician;

    public Kostya (Musician musician){
        this.musician = musician;
    }

    public void music(){
        System.out.println("Kostya: ");
        musician.doMusic();
    }

    @Override
    public String toString() {
        return "KostyaToStr";
    }
}
