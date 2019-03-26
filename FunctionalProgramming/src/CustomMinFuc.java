import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFuc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[],Integer> min = n -> Arrays.stream(n).min().getAsInt();

        System.out.println(min.apply(input));
    }
}
