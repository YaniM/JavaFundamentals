import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (numberOfCommands-- > 0) {
            String[] operation = scanner.nextLine().split("\\s+");

            int numberOperation = Integer.parseInt(operation[0]);

            if (numberOperation == 1) {
                int toPush = Integer.parseInt(operation[1]);

                stack.push(toPush);
            } else if (numberOperation == 2) {
                stack.pop();
            } else if (numberOperation == 3) {
                int max = Collections.max(stack);
                System.out.println(max);
            }

        }
    }
}
