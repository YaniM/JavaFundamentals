import java.util.Scanner;

public class Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(numbers[0]);
        int cols = Integer.parseInt(numbers[1]);

        if (rows + cols > 28) {
            return;
        }

        char ch = 97;

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                matrix[i][j] = String.valueOf(ch) + ch + ch;
            }
            ch++;
        }

        for (int i = 0; i < rows; i++) {

            char currentChar = matrix[i][0].charAt(0);

            char number = currentChar;
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j].charAt(1) == currentChar) {

                    matrix[i][j] = currentChar + String.valueOf(number) + currentChar;
                    number++;
                }
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
