import java.util.Scanner;

public class FillMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] params = scanner.nextLine().split(", ");

        int size = Integer.parseInt(params[0]);
        String letter = params[1];

        if(letter.toLowerCase().equals("a"))
        {
            int[][] matrix = methodA(size);
            print(matrix,size);
        }else if(letter.toLowerCase().equals("b"))
        {
            int[][] matrix = methodB(size);
            print(matrix,size);
        }


    }

    private static int[][] methodA(int size)
    {
        int[][] currentMatrix = new int[size][size];

        int[] numbers = new int[size];

        for (int i = 1; i <=size; i++) {
            for (int j = 1; j <size; j++) {
                numbers[0]=i;
                numbers[j]=numbers[j-1]+size;
            }
            currentMatrix[i-1]=numbers;
            numbers=new int[size];
        }

        return currentMatrix;
    }

    private static void print(int[][] matrix,int size)
    {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }

    private static int[][] methodB(int size)
    {
        int[][] currentMatrix = new int[size][size];

        int count =1;

        for (int i = 0; i < size; i++) {
            if(i%2==0)
            {
                for (int j = 0; j < size; j++) {
                    currentMatrix[j][i]=count;
                    count++;
                }
            }else
            {
                for (int j = size-1; j >=0; j--) {
                    currentMatrix[j][i]=count;
                    count++;
                }
            }
        }
        return currentMatrix;
    }
}
