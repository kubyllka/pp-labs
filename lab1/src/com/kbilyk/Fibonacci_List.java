package com.kbilyk;
import java.util.ArrayList;

/**
 * Fibonacci_List - а class that stores a list of Fibonacci numbers of a given size,
 * creates this list also creates a list of Fibonacci numbers that are cubes.
 */
public class Fibonacci_List {
    private final int size;  // the size of fibonacci list
    private final ArrayList<Fibonacci_Number> fib_list = new ArrayList<>(); // the fib list where all
    // elements are the object of class Fibonacci_Number

    /**
     * Default constructor
     */
    Fibonacci_List (){ size = 0;}

    /**
     * Constructor creates a Fibonacci list of a given size
     * @param size The size of Fibonacci List
     */
    Fibonacci_List (int size){
        this.size = size;
        create_Fib_list(size);
    }

    /**
     * Getter that which returns a Fibonacci list
     * @return The list of Fibonacci numbers
     */
    protected ArrayList<Fibonacci_Number> get_List(){return fib_list;}


    /**
     * The function creates a list of Fibonacci numbers of a given size.
     * @param size The size of Fibonacci list
     */
    protected void create_Fib_list(int size) {
        fib_list.add(new Fibonacci_Number(0, 1));
        if(size != 1){
            fib_list.add(new Fibonacci_Number(1, 1));
        }
        for (int i = 2; i < size; i++) {
            fib_list.add(new Fibonacci_Number(i, fib_list));
        }
    }

    /**
     * Creating a list of Fibonacci numbers that are cubes
     * @return The list of Fibonacci numbers that are cubes.
     */
    protected ArrayList<Fibonacci_Number> create_Cub_list() {
        ArrayList<Fibonacci_Number> cubL = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (fib_list.get(i).isCube()){
                cubL.add(fib_list.get(i));
            }
        }
        return cubL;
    }
}
