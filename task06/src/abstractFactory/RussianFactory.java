package abstractFactory;

public class RussianFactory implements Factory{
    public CircleWaffle createCircleWaffle(){
        return new CircleRussianWaffle();
    }
    public RectangleWaffle createRectangleWaffle(){
        return new RectangleRussianWaffle();
    }
}
