import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int numberOfOperation = Integer.parseInt(scanner.nextLine());

        ArrayDeque<StringBuilder> stack = new ArrayDeque<>();

        while (numberOfOperation-->0)
        {
            String[] operationsParams = scanner.nextLine().split("\\s+");

            String operation = operationsParams[0];

            switch (operation)
            {
                case "1":
                    sb.append(operationsParams[1]);
                    stack.push(new StringBuilder(sb));
                    break;
                case "2":
                    int count = Integer.parseInt(operationsParams[1]);
                    sb.delete(sb.length()-count,sb.length());
                    stack.push(new StringBuilder(sb));
                    break;
                case "3":
                    char ch = sb.charAt(Integer.parseInt(operationsParams[1])-1);
                    System.out.println(ch);
                    break;
                case "4":
                    if(stack.size()==1)
                    {
                        sb = new StringBuilder();
                    }else {
                        stack.poll();
                        sb = stack.peek();
                        break;
                    }
            }
        }
    }
}
