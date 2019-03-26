package companyroster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Employee employee = null;

        HashMap<String, Department> departments = new HashMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            switch (tokens.length) {
                case 4:
                    employee = new Employee(tokens[0], Double.parseDouble(tokens[1]));
                    break;
                case 5:
                    if (tokens[4].contains("@")) {
                        employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[4]);
                    } else {
                        employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), Integer.parseInt(tokens[4]));
                    }
                    break;
                default:
                    employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[4], Integer.parseInt(tokens[5]));
            }

            if (!departments.containsKey(tokens[3])) {
                departments.put(tokens[3], new Department(tokens[3]));
            }

            departments.get(tokens[3]).getEmployees().add(employee);
        }

        departments.entrySet().stream().min((f, s) -> s.getValue().averageSalary().compareTo(f.getValue().averageSalary()))
                .stream()
                .forEach(d->{
                    System.out.println(String.format("Highest Average Salary: %s",d.getValue().getName()));

                    d.getValue().getEmployees().stream().sorted((a,b)->b.getSalary().compareTo(a.getSalary()))
                            .forEach(e-> System.out.println(String.format("%s %.2f %s %d",e.getName(),e.getSalary(),e.getEmail(),e.getAge() )));
                });
    }
}
