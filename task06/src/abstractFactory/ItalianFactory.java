package abstractFactory;

public class ItalianFactory implements Factory{
    public CircleWaffle createCircleWaffle(){
        return new CircleItalianWaffle();
    }
    public RectangleWaffle createRectangleWaffle(){
        return new RectangleItalianWaffle();
    }
}
