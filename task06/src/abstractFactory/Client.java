package abstractFactory;

public class Client {
    private final CircleWaffle circleWaffle;
    private final RectangleWaffle rectangleWaffle;

    public Client(Factory factory) {
        circleWaffle = factory.createCircleWaffle();
        rectangleWaffle = factory.createRectangleWaffle();
    }

    public void execute() {
        circleWaffle.print();
        rectangleWaffle.print();
    }
}
