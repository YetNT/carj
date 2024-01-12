

abstract class Vehicle {
    class Tank{
        int maxCapacity;
        byte capacity;
        final int consumptionRate;
        public Tank(int i, int rate){
            maxCapacity = i;
            capacity = 0;
            consumptionRate = rate;
        }
    }

    int maxSpeed;
    Tank tank;

    public Vehicle(EngineType engineType) {
        switch (engineType){
            case VTYPE:
                maxSpeed = 500;
                tank = new Tank(250, 10);
                break;
            case WTYPE:
                maxSpeed = 650;
                tank = new Tank(300, 10);
                break;
            case XTYPE:
                maxSpeed = 800;
                tank = new Tank(400, 20);
                break;
            case YTYPE:
                maxSpeed = 1200;
                tank = new Tank(350, 5);
                break;
            case ZTYPE:
                maxSpeed = 1200;
                tank = new Tank(400,10);
                break;
            default:
                break;
        }
    }
}

public class Car extends Vehicle{
    String name;
    double price;
    public Car(String carName, double carPrice, EngineType engineType) {
        super(engineType);
        name = carName;
        price = carPrice;
    }
}