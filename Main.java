import java.util.Scanner;
import java.util.Arrays;

public class Main {

    static Car car = new Car("UNDEFINED", 4.9,EngineType.WTYPE);
    static double balance = 900_000.25;

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static void goToShop(Scanner scanner, Car[] cars) {
        clearScreen();
        String[] carNames = {"Yeares", "Geese", "Beast"};

        System.out.println("Pick a car (This will replace your current car):");
        System.out.println("(Your balance  is $" + balance + ")");
        for (Car car: cars) {
            System.out.println(car.name + ": $" + car.price);
        }

        String option = scanner.nextLine();

        if (!Arrays.asList(carNames).contains(option)) {
            System.out.println("You didn't pick something");
            System.exit(0);
        }

        switch (option) {
            case "Yeares":
                car = cars[0];
                break;
            case "Geese":
                car = cars[1];
                break;
            case "Beast":
                car = cars[2];
                break;
        }

        clearScreen();

        if (car.price > balance) {
            System.out.println("You can't afford a " + car.name);
            System.exit(0);
        }

        balance -= car.price;

        System.out.println("Cool, you got a car");
    }

    public static void drive() {
        clearScreen();
        if (car.name == "UNDEFINED") {
            System.out.println("You haven't bought a car");
            System.exit(0);
        }

        int distance = 0;

        while (car.tank.capacity != 0) {
            clearScreen();
            System.out.println("Current Tank Capacity: " + car.tank.capacity);
            System.out.println("Distance travelled: " + distance + "km");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println("Interupted!");
                System.exit(0);
            }
            distance += car.kmPerXConsumption;
            car.tank.capacity -= car.tank.consumptionRate;
        }
        
        clearScreen();
        System.out.println("You ran out of fuel!");
    }
    public static void handleOptions(Scanner scanner, Car[] cars) {
        while (true) {
            System.out.println("What do you want to do");
            System.out.println("\"shop\" - Go to the shop (Your balance: $ " + balance + ")");
            System.out.println("\"drive\" - Drive");
            System.out.println("\"(any text)\" - Exit the program");

            String o = scanner.nextLine();

            switch (o){
                case "shop":
                    goToShop(scanner, cars);
                    break;
                case "drive":
                    drive();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car yeares = new Car("Yeares", 2_500.95, EngineType.XTYPE);
        Car geese = new Car("Geese", 400.95, EngineType.WTYPE);
        Car beast = new Car("Beast", 4_000.95, EngineType.YTYPE);

        Car[] cars = {yeares, geese, beast};

        clearScreen();
        handleOptions(scanner, cars);
    }
}