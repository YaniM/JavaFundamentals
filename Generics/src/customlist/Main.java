package customlist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MyList list = new MyList<>();

        String[] input = scanner.nextLine().split("\\s+");

        while (!"END".equals(input[0])){

            String command = input[0];

            switch (command){
                case "Add":
                    list.add(input[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(input[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(input[1]));
                    break;
                case "Swap":
                    list.swap(Integer.parseInt(input[1]),Integer.parseInt(input[2]));
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(input[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    for (Object o : list) {
                        System.out.println(o);
                    }
                    break;
                case "Sort":
                    Sorter.sort(list);
                    break;
            }

            input=scanner.nextLine().split("\\s+");
        }
    }
}
