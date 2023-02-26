package abstractFactory;

import factoryMethod.Waffle;

public class CircleRussianWaffle implements CircleWaffle {
    @Override
    public void print() {
        System.out.println("Круглая российская вафля");
    }
}
