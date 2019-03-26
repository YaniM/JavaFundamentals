import java.util.Arrays;
import java.util.Scanner;

public class ReverseDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = numbers;
        }

        int row = rows-1;
        int col = cols-1;

        while (row != -1) {

            int r = row;
            int c = col;

            while (c<cols && r>=0)
            {
                System.out.print(matrix[r--][c++]+" ");
            }
            System.out.println();
            col--;

            if(col == -1)
            {
                col=0;
                row--;
            }
        }
    }
}
