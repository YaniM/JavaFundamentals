package listyIterator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .skip(1).collect(Collectors.toCollection(ArrayList::new));

        String command = scanner.nextLine();

        ListyIterator listIterator = new ListyIterator(tokens);

        while (!"END".equals(command)) {
            switch (command) {
                case "Move":
                    System.out.println(listIterator.Move());
                    break;
                case "Print":
                    try {
                        System.out.println(listIterator.Print());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(listIterator.HasNext());
                    break;
                case "PrintAll":
                    for (String s : listIterator) {
                        System.out.print(s + " ");
                    }
                    System.out.println();
            }

            command = scanner.nextLine();
        }
    }
}
