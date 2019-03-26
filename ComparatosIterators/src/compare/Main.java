package compare;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       int n = Integer.parseInt(scanner.nextLine());

        TreeSet<Person> peopleByName = new TreeSet<>(new ComparatorPeopleByNames());
        TreeSet<Person> peopleByAge = new TreeSet<>(new ComparatorPeopleByAge());

        while (n-->0) {

            String[] tokens = scanner.nextLine().split("\\s+");

            Person p = new Person(tokens[0], Integer.parseInt(tokens[1]));

            peopleByName.add(p);
            peopleByAge.add(p);
        }

        for (Person person : peopleByName) {
            System.out.println(person);
        }

        for (Person person : peopleByAge) {
            System.out.println(person);
        }

    }
}
