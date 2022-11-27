package com.kbilyk.menu;

import com.kbilyk.menu.changeAssortment.ChangeAssortmentMenu;
import com.kbilyk.menu.createBouquet.CreateBouquetMenu;
import com.kbilyk.menu.exit.ExitOption;
import com.kbilyk.menu.printAssortment.PrintAssortmentMenu;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.kbilyk.menu.MenuFunctions.executeOption;
import static com.kbilyk.menu.MenuFunctions.printMenuOptions;

/**
 * The main menu of the program which execute all possible methods in
 * program
 */
public class MainMenu {

    private Map<Integer, MenuOption> menuOptions;

    public MainMenu() {

        menuOptions = new LinkedHashMap<>();

        menuOptions.put(1, new CreateBouquetMenu());

        menuOptions.put(2, new PrintAssortmentMenu());

        menuOptions.put(3, new ChangeAssortmentMenu());

        menuOptions.put(4, new ExitOption());

    }

    public void execute(){
       while(true){
           printMenuOptions(menuOptions, "Main menu");
           executeOption(menuOptions);
       }
    }
}
