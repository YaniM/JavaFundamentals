import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Predicate<String> checkLength = str->str.length()<=n;

        String[] names = scanner.nextLine().split("\\s+");

        Arrays.stream(names)
                .filter(checkLength)
                .forEach(System.out::println);
    }
}
