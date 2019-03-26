package carsalesman;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayList<Engine> engines = new ArrayList<>();
        ArrayList<Car> cars = new ArrayList<>();

        while (n-- > 0) {
            String[] engineElements = scanner.nextLine().split("\\s+");

            String model = engineElements[0];
            int power = Integer.parseInt(engineElements[1]);

            Engine engine = null;

            if (engineElements.length == 3) {
                if (Character.isLetter(engineElements[2].charAt(0))) {
                    engine = new Engine(model, power, engineElements[2]);
                } else {
                    engine = new Engine(model, power, Integer.parseInt(engineElements[2]));
                }
            }else if(engineElements.length==4)
            {
                engine = new Engine(model,power,Integer.parseInt(engineElements[2]),engineElements[3]);
            }else if(engineElements.length==2)
            {
                engine = new Engine(model,power);
            }

            engines.add(engine);
        }

        int m = Integer.parseInt(scanner.nextLine());

        while (m-->0)
        {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String carModel = carInfo[0];
            String engineModel = carInfo[1];

            Car car = null;

            Engine engine = null;

            for (Engine eng : engines) {
                if(eng.getModel().equals(engineModel))
                {
                    engine=eng;
                }
            }

            if(carInfo.length==2)
            {

                car = new Car(carModel,engine);
            }else if(carInfo.length==3)
            {
                if (Character.isLetter(carInfo[2].charAt(0))) {
                    car = new Car(carModel,engine,carInfo[2]);
                } else {
                   car = new Car(carModel,engine,Integer.parseInt(carInfo[2]));
                }
            }else if( carInfo.length==4)
            {
                car= new Car(carModel,engine,Integer.parseInt(carInfo[2]),carInfo[3]);
            }

            cars.add(car);

        }

        cars.forEach(c-> System.out.println(c.toString()));
    }
}
