import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        HashSet<Integer> set = new HashSet<>();

        String[] divisibleNumbers = scanner.nextLine().split("\\s+");

        for (String divisibleNumber : divisibleNumbers) {
            set.add(Integer.parseInt(divisibleNumber));
        }

        Predicate<Integer> checkIfDivisible = (a -> {
            boolean isTrue = true;

            for (Integer integer : set) {
                if (a % integer != 0) {
                    isTrue = false;
                }
            }

            return isTrue;
        });

        for (int i = 1; i <= number; i++) {
            if (checkIfDivisible.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
