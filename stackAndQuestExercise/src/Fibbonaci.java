import java.util.Scanner;

public class Fibbonaci {
    static long[] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        memory = new long[n + 1];

        long result = Fib(n);
        System.out.println(result);
    }

    private static long Fib(int n) {
        if (n < 2) {
            return 1;
        }

        if (memory[n] != 0) {
            return memory[n];
        }
        return memory[n] = Fib(n - 1) + Fib(n - 2);
    }
}
