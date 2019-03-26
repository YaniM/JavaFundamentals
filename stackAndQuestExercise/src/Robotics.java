import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] robotsParams = scanner.nextLine().split(";");

        String[] robots = new String[robotsParams.length];
        int[] workingTime = new int[robotsParams.length];
        int[] processTime = new int[robotsParams.length];

        for (int i = 0; i < robotsParams.length; i++) {
            robots[i] = robotsParams[i].split("-")[0];
            workingTime[i] = Integer.parseInt(robotsParams[i].split("-")[1]);
        }

        String[] timeData = scanner.nextLine().split(":");

        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        int startTime = hours * 3600 + minutes * 60 + seconds;

        int time = 0;

        ArrayDeque<String> products = new ArrayDeque<>();
        String productInput = scanner.nextLine();

        while (!productInput.equals("End")) {
            products.offer(productInput);
            productInput = scanner.nextLine();
        }

        while (!products.isEmpty()) {
            time++;

            String currentProduct = products.pollFirst();
            boolean isAssigned = false;
            for (int i = 0; i < robots.length; i++) {
                if (processTime[i] == 0 && !isAssigned) {
                    processTime[i] = workingTime[i];
                    printTask(robots[i], startTime + time, currentProduct);
                    isAssigned = true;
                }
                if (processTime[i] > 0) {
                    processTime[i]--;
                }
            }
            if (!isAssigned) {
                products.offer(currentProduct);
            }
        }

        System.out.println();
    }

    private static void printTask(String robot, int time, String currentProduct) {
        int hours = (time / 3600) % 24;
        int minutes = (time / 60) % 60;
        int seconds = time % 60;

        DecimalFormat df = new DecimalFormat("00");

        System.out.println(String.format("%s - %s [%s:%s:%s]", robot, currentProduct, df.format(hours), df.format(minutes), df.format(seconds)));
    }
}
