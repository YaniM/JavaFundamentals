package genericbox;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayList<Double> list = new ArrayList<>();

        while (n-- > 0) {

            Double input = Double.parseDouble(scanner.nextLine());
            list.add(input);
        }

        Double element = Double.parseDouble(scanner.nextLine());

        System.out.println(Box.countElements(list, element));
    }
}
