package com.kbilyk;
import java.util.ArrayList;

public class Fibonacci_List {
    private final int n;
    private final ArrayList<Fibonacci_Number> fib_list = new ArrayList<>();

    Fibonacci_List (int n){
        this.n = n;
        create_Fib_list(n);
    }

    protected ArrayList<Fibonacci_Number> get_List(){return fib_list; }

    // створення списку фібоначчі
    protected void create_Fib_list(int n) {
        if (n != 1){
            fib_list.add(new Fibonacci_Number(0, 1));
        }
        fib_list.add(new Fibonacci_Number(1, 1));
        for (int i = 2; i < n; i++) {
            fib_list.add(new Fibonacci_Number(i, fib_list));
        }
    }

    // знаходення об'єктів списку фібоначі, які є кубами
    protected ArrayList<Fibonacci_Number> create_Cub_list() {
        ArrayList<Fibonacci_Number> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (fib_list.get(i).isCube()){
                arr.add(fib_list.get(i));
            }
        }
        return arr;
    }
}
