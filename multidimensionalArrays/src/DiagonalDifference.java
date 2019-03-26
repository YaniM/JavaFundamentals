import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            matrix[i]=numbers;
        }

        int firstSum = 0;

        int count = 0;
        for (int i = 0; i <size; i++) {
            firstSum+=matrix[i][count];
            count++;
        }

        int secondSum = 0;

        count=0;
        for (int i = size-1; i >=0 ; i--) {
            secondSum+=matrix[i][count];
            count++;
        }

        System.out.println(Math.abs(firstSum-secondSum));
    }
}
