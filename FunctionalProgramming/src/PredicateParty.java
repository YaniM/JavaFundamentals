import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputNames = scanner.nextLine().split("\\s+");

        List<String> names = Arrays.stream(inputNames).collect(Collectors.toList());

        String line = scanner.nextLine();

        BiPredicate<String, String> startsWith = String::startsWith;
        BiPredicate<String, String> endsWith = String::endsWith;
        BiPredicate<String, String> byLength = (str, len) -> {
            int size = Integer.parseInt(len);
            return str.length() == size;
        };

        BiPredicate<String, String> mainPredicate = startsWith;

        while (!line.equals("Party!")) {
            String[] tokens = line.split("\\s+");

            messingWithList(names, tokens);

            line = scanner.nextLine();
        }


        if (names.size() == 0) {
            System.out.println("Nobody is going to the party!");
        } else {
            names = names.stream().sorted(String::compareTo).collect(Collectors.toList());

            System.out.println(String.join(", ", names) + " are going to the party!");
        }
    }

    private static void messingWithList(List<String> names, String[] tokens) {
        BiPredicate<String, String> startsWith = String::startsWith;
        BiPredicate<String, String> endsWith = String::endsWith;
        BiPredicate<String, String> length = (str, len) -> {
            int size = Integer.parseInt(len);
            return str.length() == size;
        };

        String mainCmd = tokens[0];
        String cmd = tokens[1];
        String identity = tokens[2];

        BiPredicate<String, String> mainPredicate = startsWith;

        if (cmd.equals("EndsWith")) {
            mainPredicate = endsWith;
        } else if (cmd.equals("Length")) {
            mainPredicate = length;
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        if (mainCmd.equals("Double")) {
            for (int i = 0; i < names.size(); i++) {
                if (mainPredicate.test(names.get(i), identity)) {
                    stack.push(i);
                }
            }
            for (Integer index : stack) {
                String name = names.get(index);
                names.add(index, name);
            }
        } else {
            for (int i = names.size() - 1; i >= 0; i--) {
                if (mainPredicate.test(names.get(i), identity)) {
                    names.remove(names.get(i));
                }
            }
        }
    }
}
