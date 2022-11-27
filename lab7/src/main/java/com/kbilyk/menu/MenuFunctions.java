package com.kbilyk.menu;

import java.util.Map;

import static com.kbilyk.inputOutput.InputControl.enterCorrectInt;
import static com.kbilyk.inputOutput.MakeBeautyOutput.*;

public class MenuFunctions {

    /**
     * Display the menu options with the name of menu
     * @param menu The map of menu option
     * @param info The info about menu
     */
    public static void printMenuOptions(Map<Integer, MenuOption> menu, String info){
        printBanner(info);
        menu.forEach((key, value) -> System.out.println(key + ". " + value.getOptionName()));
        System.out.println(line);
    }

    /**
     * Display the menu options without the name of menu
     * @param menu The map of menu option
     */
    public static void printOptions(Map<Integer, MenuOption> menu){
        System.out.println(line);
        menu.forEach((key, value) -> System.out.println(key + ". " + value.getOptionName()));
        System.out.println(line);
    }

    /**
     * A method for the user to select a menu option
     * @param menu The menu options
     * @return The option selected by the user
     */
    public static MenuOption executeOption(Map<Integer, MenuOption> menu){
        System.out.println("Choose option:");
        int numOption = enterCorrectInt();

        if(menu.get(numOption) != null){
           menu.get(numOption).execute();
           return menu.get(numOption);
        }
        else{
            printError("Oooops... Incorrect option. Try again");
            return executeOption(menu);
        }
    }
}
