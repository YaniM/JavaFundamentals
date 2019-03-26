import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Email {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,String> map = new LinkedHashMap<>();

        while (true)
        {
            String name = scanner.nextLine();

            if("stop".equals(name))
            {
                break;
            }

            String email = scanner.nextLine();

            if(email.toLowerCase().endsWith("us"))
            {
                continue;
            }else if(email.toLowerCase().endsWith("uk"))
            {
               continue;
            }else if(email.toLowerCase().endsWith("com"))
            {
               continue;
            }else
            {
                map.put(name,email);
            }
        }

        for (String s : map.keySet()) {

            System.out.println(String.format("%s -> %s",s, map.get(s)));
        }
    }
}
