package com.kbilyk;
import java.util.ArrayList;

/**
 * Fibonacci_Number - is a class which stores information about the value of
 * a Fibonacci number, its sequence number, creates a new Fibonacci value and
 * checks whether the number is a cube.
 */
public class Fibonacci_Number{
    private long value;  // the ordinal number of the Fibonacci number
    private final int index;  // the value of Fibonacci number

    /**
     * Default constructor when sets the value directly
     * @param index The ordinal number of the Fibonacci number
     * @param value The value of Fibonacci number
     */
    Fibonacci_Number(int index, long value)
    {
        this.index = index;
        this.value = value;
    }

    /**
     * Constructor if want to generate new Fib number
     * based on previous ones.
     *
     * @param index The ordinal number of the Fibonacci number
     * @param fList The list of Fibonacci numbers
     */
    Fibonacci_Number(int index, ArrayList<Fibonacci_Number> fList){
        this.index = index;
        generateNewNum(fList);
    }

    /**
     * Setter that set new value of Fibonacci number
     * @param n - The value of Fibonacci number
     */
    public void setValue(int n) { value = n; }

    /**
     * Get the index of Fibonacci number
     * @return The index of Fibonacci number
     */
    public int getIndex() { return index; }

    /**
     * Get the value of Fibonacci number
     * @return The value of Fibonacci number
     */
    public long getValue() { return value; }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * Сhecks whether a number is a cube
     * @return True if the cube root is an integer and else False
     */
    public boolean isCube(){
        return (Math.pow(value, 1.0/3) % 1) == 0;
    }

    /**
     * Generating a new Fibonacci value based on two previous values
     * @param arr The list of Fibonacci numbers
     */
    protected void generateNewNum(ArrayList<Fibonacci_Number> arr){
        if (arr.size() < 2){
            System.out.println("Cannot generate a new Fibonacci value!" +
                    "Set the value manually using setValue()!");
            return;
        }
        value = arr.get(index - 1).getValue() +  arr.get(index - 2).getValue();
    }
}
