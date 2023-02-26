package factoryMethod;

public class RectangleWaffleCreator extends WaffleCreator{
    @Override
    public Waffle factoryMethod() {
        return new RectangleWaffle();
    }
}
