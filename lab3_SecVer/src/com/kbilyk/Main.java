package com.kbilyk;
import com.kbilyk.Controllers.Menu;
import com.kbilyk.Droids.DroidList;

import java.io.FileNotFoundException;

/**
 * Main of game
 * Create droids list and call menu that do other options
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("\nNULP BATTLE\n"); // the name of the game

        DroidList droidList = new DroidList(); // the list of droids
        Menu menu = new Menu(droidList);       // call menu with options

    }
}