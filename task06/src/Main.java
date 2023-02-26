
import abstractFactory.Client;
import abstractFactory.Factory;
import abstractFactory.ItalianFactory;
import abstractFactory.RussianFactory;
import builder.*;
import factoryMethod.*;
import prototype.Packing;

public class Main {
    public static void main(String[] args) {
        System.out.println("Factory method example: ");
        WaffleCreator[] waffleCreators = {new CircleWaffleCreator(), new RectangleWaffleCreator()};
        for (WaffleCreator waffleCreator : waffleCreators) {
            Waffle waffle = waffleCreator.factoryMethod();
            waffle.print();
        }
        System.out.println();

        System.out.println("Abstract factory example: ");
        Factory[] factories = {new RussianFactory(), new ItalianFactory()};
        for (Factory factory : factories) {
            Client client = new Client(factory);
            client.execute();
        }
        System.out.println();

        System.out.println("Builder example: ");
        Builder[] builders = {new TeslaBuilder(), new BMVBuilder()};
        for (Builder builder : builders) {
            Director director = new Director(builder);
            director.Construct();
            Car car = builder.GetResult();
            car.print();
        }
        System.out.println();

        System.out.println("Prototype example: ");
        Packing originalPacking = new Packing();
        Packing[] packingArray = new Packing[5];
        for (int i = 0; i < 5; i++) {
            try {
                packingArray[i] = originalPacking.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            packingArray[0].print();
        }
        System.out.println();
    }
}