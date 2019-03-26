import java.util.LinkedHashMap;
import java.util.Scanner;

public class Miner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String,Long> map = new LinkedHashMap<>();

        while (true)
        {
            String resource = scanner.nextLine();

            if("stop".equals(resource))
            {
                break;
            }

            long  quantity = Long.parseLong(scanner.nextLine());

            if(map.keySet().contains(resource))
            {
                    map.put(resource,map.get(resource)+quantity);
            }else {
                map.put(resource, quantity);
            }
        }

        for (String s : map.keySet()) {
            System.out.println(String.format("%s -> %d",s,map.get(s)));
        }
    }
}
