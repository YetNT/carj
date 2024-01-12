import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        Car yeares = new Car("Yeares", 2_500.90, EngineType.XTYPE);
        Car geese = new Car("Geese", 400.99, EngineType.WTYPE);
        Car beast = new Car("Beast", 4_000.94, EngineType.YTYPE);

        Car[] cars = {yeares, geese, beast};
        String[] carNames = {"Yeares", "Geese", "Beast"};

        System.out.println("Pick a car:");
        for (Car car: cars) {
            System.out.println(car.name + ": $" + car.price);
        }

        String option = scanner.nextLine();

        if (!Arrays.asList(carNames).contains(option)) {
            System.out.println("You didn't pick something");
            System.exit(0);
        }

        Car car = new Car("r", 4.9,EngineType.WTYPE);

        switch (option) {
            case "Yeares":
                car = yeares;
                break;
            case "Geese":
                car = geese;
                break;
            case "Beast":
                car = beast;
                break;
        }

        System.out.println("Cool, your car has a capacity of " + car.tank.maxCapacity +"  litres can go  up to " + car.maxSpeed + "km\\h");
        scanner.close();
    }
}