package builder;

public class TeslaBuilder implements Builder{
    Car car = new Car();

    @Override
    public void BuildEngine() {
        car.buildEngine("Электродвигатель");
    }

    @Override
    public void SetDirector() {
        car.setDirector("Тесла");
    }

    @Override
    public Car GetResult() {
        return car;
    }
}
