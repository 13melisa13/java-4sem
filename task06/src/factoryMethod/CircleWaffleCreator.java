package factoryMethod;

public class CircleWaffleCreator extends WaffleCreator{
    @Override
    public Waffle factoryMethod() {
        return new CircleWaffle();
    }
}
