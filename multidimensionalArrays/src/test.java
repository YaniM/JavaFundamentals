import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimension = scanner.nextLine().split("\\s+");
        
        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i]=arr;
        }

        int startRow = rows-1;
        int startcol = cols-1;

        while (startRow !=-1)
        {
            int r = startRow;
            int c =startcol;

            while (c<cols && r>=0)
            {
                System.out.print(matrix[r--][c++]+ " ");
            }
            System.out.println();

            startcol--;

            if(startcol==-1)
            {
                startcol=0;
                startRow--;
            }

        }
    }
}
