import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] input = scanner.nextLine().split("\\s+");

        int toAdd = Integer.parseInt(input[0]);
        int toRemove = Integer.parseInt(input[1]);
        int toCheck = Integer.parseInt(input[2]);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        String[] numbers = scanner.nextLine().split("\\s+");
        for (int i = 0; i <toAdd ; i++) {
            queue.offer(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < toRemove; i++) {
            queue.poll();
        }

        if(queue.contains(toCheck))
        {
            System.out.println(true);
        }else
        {
            if(toRemove==numbers.length)
            {
                System.out.println(0);
                return;
            }

            int min = Collections.min(queue);
            System.out.println(min);
        }
    }
}
