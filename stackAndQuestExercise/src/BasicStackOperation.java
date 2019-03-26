import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperation {
    static int smallestElement = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] opeartion = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int toPush = Integer.parseInt(opeartion[0]);
        int toPop = Integer.parseInt(opeartion[1]);
        int toFind = Integer.parseInt(opeartion[2]);

        String[] numbers = scanner.nextLine().split("\\s+");

        for (int i = 0; i < toPush; i++) {
            stack.push(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < toPop; i++) {
            stack.pop();
        }

        boolean contains = stack.contains(toFind);

        if(contains)
        {
            System.out.println(true);
        }else
        {
            if(toPop==numbers.length)
            {
                System.out.println("0");
                return;
            }

            for (Integer integer : stack) {
                smallestElement = minValue(integer);
            }
            System.out.println(smallestElement);
        }

    }

    private static Integer minValue(int value)
    {

        if(value<smallestElement)
        {
            smallestElement=value;
        }
        return smallestElement;
    }
}
