import java.util.ArrayList;
import java.util.Scanner;

public class MatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputRotate = scanner.nextLine().split("[()]+");

        int rotateDegree = Integer.parseInt(inputRotate[1]) % 360;

        ArrayList<String> list = new ArrayList<>();

        String inputWords = scanner.nextLine();

        int maxLenght = 0;

        while (!inputWords.equals("END")) {
            int lenght = inputWords.length();
            if (lenght > maxLenght) {
                maxLenght = lenght;
            }
            list.add(inputWords);
            inputWords = scanner.nextLine();
        }

        int rows = list.size();
        int cols = maxLenght;

        char[][] matrix = new char[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                String currentWord = list.get(r);

                if (c > currentWord.length() - 1) {
                    matrix[r][c] = ' ';
                } else {
                    matrix[r][c] = currentWord.charAt(c);
                }
            }
        }

        if (rotateDegree == 90) {
            for (int c = 0; c < cols; c++) {
                for (int r = rows - 1; r >= 0; r--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        } else if (rotateDegree == 180) {
            for (int r = rows-1; r>=0; r--) {
                for (int c = cols-1; c >=0; c--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        }else if(rotateDegree==270)
        {
            for (int c = cols-1; c>=0 ; c--) {
                for (int r = 0; r < rows; r++) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        }else
        {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        }
    }
}
