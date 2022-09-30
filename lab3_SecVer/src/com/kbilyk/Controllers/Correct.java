package com.kbilyk.Controllers;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The class help the check if the input from user is correct.
 */
public class Correct {

    /**
     * Checks whether a number is within a given range
     * @param minInt The minimum value of range
     * @param maxInt The maximum value of range
     * @return The number
     */
    public static int checkCorrect(int minInt, int maxInt){
        int num = 0;
        try{
            System.out.println("Type a num: ");
            Scanner input = new Scanner(System.in);
            num = input.nextInt();

            // if value out of range
            if(num < minInt || num > maxInt){
                System.out.println("Wrong num! You must type from " + minInt + " to " + maxInt + " Try again!");
                return checkCorrect(minInt, maxInt);
            }
        } catch(InputMismatchException e){
            // if value is letter
            System.out.println("Wrong symbol! You must type from " + minInt + " to " + maxInt + " Try again!");
            return checkCorrect(minInt, maxInt);
        }
        return num;
    }
}
