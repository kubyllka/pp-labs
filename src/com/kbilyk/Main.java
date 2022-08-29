package com.kbilyk;
import java.util.ArrayList;

/**
 * 3.	Визначити, які числа серед перших N чисел Фібоначчі є кубами.
 */
public class Main {
    public static void main(String[] args) {
        int n;
        n = entering_n(args);
        // об'єкт списку фібоначі, який скаладається з об'єктів числа фібоначі
        Fibonacci_List fib_list = new Fibonacci_List(n);
        System.out.println("The Fibonacci array for " + n + " elements: ");
        System.out.println(fib_list.get_List());
        // метод класу списку фібоначі обробляє масив та повертає об'єкти
        // числа Фібоначі, які є кубами
        ArrayList <Fibonacci_Number> a = fib_list.create_Cub_list();
        System.out.println("Fibonacci cubes for " + n + " elements: ");
        System.out.println(a);
    }

    private static int entering_n(String[] args){
        return 7;
    }


}