package com.kbilyk;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.kbilyk.FilterFlower.filteredFlowers;

public class Error {

    static Scanner input = new Scanner(System.in);
    /**
     * Checks that input is a integer number
     * @return The the integer number
     */
    public static int enterCorrectInt() {
        int num = 0;
        try {
            num = input.nextInt();

        } catch (InputMismatchException e) {
            // if value is letter
            System.out.println("Wrong symbol! You must type a num! Try again");
            return enterCorrectInt();
        }
            return num;
    }


}
