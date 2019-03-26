import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j]=data[j];
            }
        }

        String[] input = scanner.nextLine().split("\\s+");

        while (!input[0].toLowerCase().equals("end"))
        {
            if(input[0].equals("swap") && input.length==5)
            {
                int currRows = Integer.parseInt(input[1]);
                int currCols = Integer.parseInt(input[2]);
                int futureRows = Integer.parseInt(input[3]);
                int futureCols = Integer.parseInt(input[4]);

                if(currRows>=rows||futureRows>=rows || currCols>=cols || futureCols>=cols)
                {
                    System.out.println("Invalid input!");
                    input=scanner.nextLine().split("\\s+");
                    continue;
                }

                String temp = matrix[futureRows][futureCols];
                matrix[futureRows][futureCols]=matrix[currRows][currCols];
                matrix[currRows][currCols]=temp;

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        System.out.print(matrix[i][j]+ " ");
                    }
                    System.out.println();
                }

            }else
            {
                System.out.println("Invalid input!");
            }

            input=scanner.nextLine().split("\\s+");
        }
    }
}
