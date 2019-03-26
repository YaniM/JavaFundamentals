package rawdata;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashSet<Car> cars = new LinkedHashSet<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String carModel = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            Tire tire1 = new Tire(Double.parseDouble(tokens[5]), Integer.parseInt(tokens[6]));
            Tire tire2 = new Tire(Double.parseDouble(tokens[7]), Integer.parseInt(tokens[8]));
            Tire tire3 = new Tire(Double.parseDouble(tokens[9]), Integer.parseInt(tokens[10]));
            Tire tire4 = new Tire(Double.parseDouble(tokens[11]), Integer.parseInt(tokens[12]));
            ArrayList<Tire> tires = new ArrayList<>();
            tires.add(tire1);
            tires.add(tire2);
            tires.add(tire3);
            tires.add(tire4);

            Engine engine = new Engine(engineSpeed, enginePower);

            Cargo cargo = new Cargo(cargoWeight, cargoType);

            Car car = new Car(carModel, engine, cargo, tires);

            cars.add(car);
        }

        String command = scanner.nextLine();

        if (command.equals("fragile")) {
            for (Car car : cars) {
                if (car.getCargo().getType().equals("fragile") && car.getTires().stream().anyMatch(a -> a.getPressure() < 1)) {
                    System.out.println(car.getModel());
                }
            }
        } else if (command.equals("flamable")) {
            for (Car car : cars) {
                if (car.getCargo().getType().equals("flamable") && car.getEngine().getPower() > 250) {
                    System.out.println(car.getModel());
                }
            }
        }
    }
}
