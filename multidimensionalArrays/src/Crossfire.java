import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

       ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        int count = 1;

        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
               list.add(count++);
            }
            matrix.add(list);
        }

        String input = scanner.nextLine();

        while (!input.equals("Nuke it from orbit"))
        {
            String[] params = input.split("\\s+");

            int targetRow = Integer.parseInt(params[0]);
            int targetCol = Integer.parseInt(params[1]);
            int radius = Integer.parseInt(params[2]);

            int rowStart = Math.max(0, targetRow - radius);
            int rowEnd = Math.min(rows - 1, targetRow + radius);
            int colStart = Math.max(0, targetCol - radius);
            int colEnd = Math.min(cols - 1, targetCol + radius);


            for (int r = rowStart; r <=rowEnd ; r++) {

                if(isInRange(r,targetCol,matrix))
                {
                    matrix.get(r).set(targetCol,0);
                }
            }

            for (int c = colStart; c <=colEnd ; c++) {

                if(isInRange(targetRow,c,matrix))
                {
                    matrix.get(targetRow).set(c,0);
                }
            }


            for (int i = 0; i < matrix.size(); i++) {
               List<Integer> list = matrix.get(i);

               matrix.forEach(r->r.removeIf(v->v==0));
               matrix.removeIf(List::isEmpty);
            }
            input=scanner.nextLine();
        }

        for (int i = 0; i < matrix.size(); i++) {
            ArrayList<Integer> temp = matrix.get(i);
            for (int j = 0; j < temp.size(); j++) {
                System.out.print(temp.get(j) + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInRange(int row,int col,ArrayList<ArrayList<Integer>> matrix)
    {
        return row >= 0 && row < matrix.size() &&
                col >= 0 && col < matrix.get(row).size();
    }
}
