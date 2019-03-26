import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int rowsSize = Integer.parseInt(input[0]);
        int colsSize = Integer.parseInt(input[1]);

        int[][] matrix = new int[rowsSize][colsSize];

        for (int rows = 0; rows < rowsSize; rows++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[rows]=numbers;
        }

        int sum = Integer.MIN_VALUE;
        int rows =0,cols=0;
        for (int i = 0; i < rowsSize-2; i++) {
            for (int j = 1; j < colsSize-1; j++) {
                int currentSum = calSum(matrix,i,j);

                if(currentSum>sum)
                {
                    sum=currentSum;
                    rows=i;
                    cols=j;
                }
            }
        }
        System.out.println("Sum = "+ sum);
        System.out.println(String.format("%d %d %d ",matrix[rows][cols-1],matrix[rows][cols],matrix[rows][cols+1]));
        System.out.println(String.format("%d %d %d ",matrix[rows+1][cols-1],matrix[rows+1][cols],matrix[rows+1][cols+1]));
        System.out.println(String.format("%d %d %d",matrix[rows+2][cols-1],matrix[rows+2][cols],matrix[rows+2][cols+1]));
    }

    private static int calSum(int[][] matrix, int rows, int cols) {

        return matrix[rows][cols]+matrix[rows][cols+1]+matrix[rows][cols-1]+matrix[rows+1][cols]+matrix[rows+1][cols-1]+matrix[rows+1][cols+1]+
                matrix[rows+2][cols]+matrix[rows+2][cols-1]+matrix[rows+2][cols+1];
    }
}
