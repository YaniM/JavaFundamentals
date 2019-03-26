import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> map = new TreeMap<>();

        while (true) {
            String[] input = scanner.nextLine().split("[=\\s+]+");

            if (input[0].equals("end")) {
                break;
            }

            String ip = input[1];
            String user = input[5];

            LinkedHashMap<String, Integer> temp = new LinkedHashMap<>();

            if (map.containsKey(user)) {
                temp = map.get(user);
            }

            if (temp.containsKey(ip)) {
                temp.put(ip, temp.get(ip) + 1);
            } else {
                temp.put(ip, 1);
            }

            map.put(user, temp);
        }

        for (String user : map.keySet()) {
            System.out.println(String.format("%s: ", user));
            List<String> list = new ArrayList<>();
            for (String ip : map.get(user).keySet()) {
                int count = map.get(user).get(ip);

                String params = ip + " => " + count;

                list.add(params);
            }
            String infoPrint = String.join(", ", list);

            System.out.print(infoPrint + ".");
            System.out.println();
        }
    }
}
