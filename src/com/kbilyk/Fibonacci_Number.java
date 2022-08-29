package com.kbilyk;

import java.util.ArrayList;
public class Fibonacci_Number{

    private int value;
    private final int index;
    // коли задаємо значення напряму
    Fibonacci_Number(int index, int value)
    {
        this.index = index;
        this.value = value;
    }
    // коли просимо задаємо лише індекс
    Fibonacci_Number(int index, ArrayList<Fibonacci_Number> a){
        this.index = index;
        this.value = generateNewNum(a);
    }

    public int getValue() { return value;}

    public int getIndex() { return index;}
    // перевантаження виведення
    public String toString(){
        return String.valueOf(value);
    }

    public boolean isCube(){
        return (Math.pow(value, 1.0/3) % 1) == 0;
    }
    // генерування нового значення, якщо відомий лише індекс
    public int generateNewNum(ArrayList<Fibonacci_Number> arr) {
        value = arr.get(index - 1).getValue() +  arr.get(index - 2).getValue();
        return value;
    }
}
