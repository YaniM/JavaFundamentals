import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsername {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> set = new LinkedHashSet<>();

        int numbersOfInput = Integer.parseInt(scanner.nextLine());

        while (numbersOfInput-->0)
        {
            String input = scanner.nextLine();

            set.add(input);
        }

        for (String s : set) {
            System.out.println(s);
        }
    }
}
