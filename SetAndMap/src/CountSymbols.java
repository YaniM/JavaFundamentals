import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Character,Integer> map = new TreeMap<>();

        char[] input = scanner.nextLine().toCharArray();

        for (int i = 0; i < input.length; i++) {
            char ch = input[i];

            if(!map.keySet().contains(ch))
            {
                map.put(ch,1);
            }else
            {
                map.put(ch,map.get(ch)+1);
            }
        }

        for (Character ch : map.keySet()) {
            System.out.println(String.format("%c: %d time/s",ch,map.get(ch)));
        }
    }
}
