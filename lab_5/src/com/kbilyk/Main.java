package com.kbilyk;

import com.kbilyk.menu.MainMenu;

import static com.kbilyk.сonstant.FlowerType.LUPINE;

/**
 * The method main that call main menu of the program
 */
public class Main {
    public static void main(String[] args) {

        Assortment.flowers.add(new Flower(1, 3,5,"blue", LUPINE));
        Assortment.flowers.add(new Flower(2, 3,5,"blue", LUPINE));
        Assortment.flowers.add(new Flower(3, 3,5,"blue", LUPINE));

        MainMenu mainMenu = new MainMenu();

        while(true){

            mainMenu.printOptions();
            mainMenu.execute();

        }
    }

}