import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        BiPredicate<Map.Entry<String,Integer>, Integer> youngerThan = (personAge, ageLimit) -> personAge.getValue() < ageLimit;
        BiPredicate<Map.Entry<String,Integer>, Integer> olderThan = (personAge, ageLimit) -> personAge.getValue() >= ageLimit;

        Consumer<Map.Entry<String,Integer>> printName = p -> System.out.println(p.getKey());
        Consumer<Map.Entry<String,Integer>> printAge = p -> System.out.println(p.getValue());
        Consumer<Map.Entry<String,Integer>> printNameAge = p -> System.out.println(String.format("%s - %d",p.getKey(),p.getValue()));

        int size = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < size; i++) {
            String[] input = scanner.nextLine().split(", ");

            people.put(input[0], Integer.parseInt(input[1]));
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

            people.entrySet().stream()
                    .filter(x->
                           condition.equals("younger") ? youngerThan.test(x,age): olderThan.test(x,age))
                    .forEach(person -> {
                        if(format.equals("age"))
                        {
                            printAge.accept(person);
                        }else if(format.equals("name"))
                        {
                            printName.accept(person);
                        }else
                        {
                            printNameAge.accept(person);
                        }
                    });

    }
}
