import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> set = new TreeSet<>();

        int numberOfInput = Integer.parseInt(scanner.nextLine());

        while (numberOfInput-->0)
        {
            String[] elements = scanner.nextLine().split("\\s+");

            set.addAll(Arrays.asList(elements));
        }

        for (String s : set) {
            System.out.printf("%s ",s);
        }
    }
}
