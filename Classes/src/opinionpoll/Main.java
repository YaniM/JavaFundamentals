package opinionpoll;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayList<Person> persons = new ArrayList<>();

        while (n-->0)
        {
            String[] tokens = scanner.nextLine().split("\\s+");

            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));

            persons.add(person);

        }

        persons.stream().sorted((a,b)->a.getName().compareTo(b.getName()))
                .filter(a->a.getAge()>30)
                .forEach(p-> System.out.println(String.format("%s - %d",p.getName(),p.getAge())));
    }
}
