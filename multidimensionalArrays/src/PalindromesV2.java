import java.util.Scanner;

public class PalindromesV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] number = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(number[0]);
        int cols = Integer.parseInt(number[1]);

        String[] alphabet = {
                "a", "b", "c", "d", "e", "f", "g", "h", "i",
                "j", "k", "l", "m", "n", "o", "p", "q", "r",
                "s", "t", "u", "v", "w", "x", "y", "z"
        };

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j]=alphabet[i]+alphabet[j+i]+alphabet[i];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
