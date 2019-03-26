package google;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        HashMap<String, Person> persons = new HashMap<>();

        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");

            String personName = tokens[0];
            String objectName = tokens[1];

            Person person = null;

            if (persons.containsKey(personName)) {
                Person person1 = persons.get(personName);

                person = person1;
            }

            if (objectName.equals("company")) {
                String companyName = tokens[2];
                String department = tokens[3];
                Double salary = Double.parseDouble(tokens[4]);

                Company company = new Company(companyName, department, salary);
                if (person == null) {
                    person = new Person(personName, company);
                }else
                {
                    person.setCompany(company);
                }
            } else if (objectName.equals("pokemon")) {
                String pokemonName = tokens[2];
                String pokemonType = tokens[3];

                Pokemon pokemon = new Pokemon(pokemonName, pokemonType);

                if (person == null) {
                    person = new Person(personName);
                    person.getPokemons().add(pokemon);
                }else
                {
                    person.getPokemons().add(pokemon);
                }

            } else if (objectName.equals("parents")) {
                String parentName = tokens[2];
                String parentBday = tokens[3];

                Parent parent = new Parent(parentName, parentBday);

                if (person == null) {
                    person = new Person(personName);
                    person.getParents().add(parent);
                }else
                {
                    person.getParents().add(parent);
                }
            } else if (objectName.equals("children")) {
                String childName = tokens[2];
                String childBday = tokens[3];

                Children children = new Children(childName, childBday);

                if (person == null) {
                    person = new Person(personName);
                    person.getChildren().add(children);
                }else
                {
                    person.getChildren().add(children);
                }

            } else if (objectName.equals("car")) {
                String carModel = tokens[2];
                int speed = Integer.parseInt(tokens[3]);

                Car car = new Car(carModel, speed);

                if (person == null) {
                    person = new Person(personName,car);
                }else
                {
                    person.setCar(car);
                }
            }

            if (!persons.containsKey(personName)) {
                persons.put(personName, person);
            }else
            {
                persons.put(personName,person);
            }

            line = scanner.nextLine();
        }

        String namePrint = scanner.nextLine();


        for (Person person : persons.values()) {
            if(person.getName().equals(namePrint))
            {
                System.out.println(person);

            }
        }

        System.out.println();
    }
}
