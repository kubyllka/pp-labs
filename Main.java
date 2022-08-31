package com.kbilyk;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  Variant 3.
 *  Determine which numbers among the first N Fibonacci numbers are cubes.
 */
public class Main {
    public static void main(String[] args) {
        int n;
        // entering the size of fibonacci array
        if (args.length != 0){
            n = enteringCommand(args);
        }else{
            n = enteringConsole();
        }
        // declaration of a Fibonacci list object, which consists of Fibonacci number objects
        Fibonacci_List fib_list = new Fibonacci_List(n);
        System.out.println("The Fibonacci array for " + n + " elements: ");
        System.out.println(fib_list.get_List());

        // creating a new list with Fibonacci numbers that are cubes
        ArrayList<Fibonacci_Number> cubL = fib_list.create_Cub_list();
        System.out.println("Fibonacci cubes for " + n + " elements: ");
        System.out.println(cubL);
    }

    /**
     * Entering the number of Fibonacci numbers using the console
     * @return The size of Fibonacci list
     */
    protected static int enteringConsole() {
        int n;
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter size (N) of Fibonacci list Min(N) - 1, Max(N) - 92: ");
            n = scan.nextInt();
            // 92 is the maximum number whose value is in the range long
            if (n <= 0 || n > 92) {
                System.out.println("Wrong number! Min(N) - 1, Max(N) - 92!");
            } else {
                return n;
            }
        }
    }

    /**
     * Entering the size of Fibonacci numbers using the command-line
     * @param args The Sting of command-line arguments
     * @return The number of Fibonacci numbers
     */
    private static int enteringCommand(String[] args) {
        int n;
        n = Integer.parseInt(args[0]);
        // 92 is the maximum number whose value is in the range long
        if (n <= 0 || n > 92){
            System.out.println("Wrong number! Min(N) - 1, Max(N) - 92!");
            java.lang.System.exit(0);
        }
        return n;
    }
}


