import java.util.ArrayDeque;
import java.util.Scanner;

public class Parenteses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> openingBrackets = new ArrayDeque<>();

        boolean isTrue = true;

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (current == '{' || current == '[' || current == '(') {
                openingBrackets.push(current);
            } else {
                if(openingBrackets.isEmpty())
                {
                    isTrue=false;
                    break;
                }
                char opening = openingBrackets.pop();

                if(current=='}' &&  opening !='{')
                {
                    isTrue=false;
                    break;
                }else if(current==']' && opening !='[')
                {
                    isTrue=false;
                    break;
                }else if(current==')' && opening!='(')
                {
                    isTrue=false;
                    break;
                }
            }
        }

        if (isTrue)
        {
            System.out.println("YES");
        }else
        {
            System.out.println("NO");
        }
    }
}
