import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Arithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        int n = Integer.parseInt(scanner.nextLine());

        BiFunction<ArrayList<Integer>, Integer, ArrayList<Integer>> reverse = ((arr, number) -> {
            Collections.reverse(arr);

            return arr.stream()
                    .filter(a->a%number !=0)
                    .collect(Collectors.toCollection(ArrayList::new));
        });

        reverse.apply(numbers,n).forEach(num -> System.out.print(num + " "));
    }
}
