

abstract class Vehicle {
    class Tank{
        int maxCapacity;
        int capacity;
        final int consumptionRate;
        public Tank(int i, int rate){
            maxCapacity = capacity = i;
            consumptionRate = rate;
        }
    }

    int maxSpeed;
    int kmPerXConsumption;
    Tank tank;

    public Vehicle(EngineType engineType) {
        switch (engineType){
            case VTYPE:
                maxSpeed = 50;
                tank = new Tank(250, 10);
                break;
            case WTYPE:
                maxSpeed = 65;
                tank = new Tank(300, 10);
                break;
            case XTYPE:
                maxSpeed = 80;
                tank = new Tank(400, 20);
                break;
            case YTYPE:
                maxSpeed = 120;
                tank = new Tank(350, 5);
                break;
            case ZTYPE:
                maxSpeed = 120;
                tank = new Tank(400,10);
                break;
            default:
                break;
        }

        kmPerXConsumption = maxSpeed / 2;
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