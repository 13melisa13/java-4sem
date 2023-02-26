package builder;

public class BMVBuilder implements Builder{
    Car car = new Car();

    @Override
    public void BuildEngine() {
        car.buildEngine("Двигатель внутреннего сгорания");
    }

    @Override
    public void SetDirector() {
        car.setDirector("БМВ");
    }

    @Override
    public Car GetResult() {
        return car;
    }
}
