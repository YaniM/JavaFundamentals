import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));


        Comparator<Integer> comparator = ((a, b) ->
        {
            if (a % 2 == 0 && b % 2 != 0) {
                return -1;
            } else if (b % 2 == 0 && a % 2 != 0) {
                return 1;
            }else{
              return a.compareTo(b);
            }
        });

        numbers.stream().sorted(comparator).forEach(a-> System.out.print(a + " "));
    }
}
