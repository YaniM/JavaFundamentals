import java.util.Scanner;
import java.util.TreeMap;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String,String> map = new TreeMap<>();

        String input = scanner.nextLine();

        while (!"search".equals(input))
        {
            String name = input.split("-")[0];
            String phoneNumber = input.split("-")[1];

            map.put(name,phoneNumber);
            input=scanner.nextLine();
        }

        input=scanner.nextLine();
        while (!"stop".equals(input))
        {
            if(map.keySet().contains(input))
            {
                System.out.println(String.format("%s -> %s",input,map.get(input)));
            }else
            {
                System.out.println(String.format("Contact %s does not exist.",input));
            }

            input=scanner.nextLine();
        }
    }
}
