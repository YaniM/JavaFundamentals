import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> set1 = new LinkedHashSet<>();
        LinkedHashSet<Integer> set2 = new LinkedHashSet<>();
        LinkedHashSet<Integer> repeatingElements = new LinkedHashSet<>();

        int[] inputSize = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < inputSize[0]; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            set1.add(number);
        }

        for (int i = 0; i < inputSize[1]; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            set2.add(number);
        }

        for (Integer int1 : set1) {
            for (Integer int2 : set2) {
                if(int2.equals(int1))
                   repeatingElements.add(int2);
            }
        }

        for (Integer repeatingElement : repeatingElements) {
            System.out.printf(String.format("%d",repeatingElement));
        }

    }
}
