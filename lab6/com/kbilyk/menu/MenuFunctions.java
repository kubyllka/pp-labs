package com.kbilyk.menu;

import java.util.Map;

import static com.kbilyk.inputOutput.InputControl.enterCorrectInt;
import static com.kbilyk.inputOutput.MakeBeautyOutput.*;

public class MenuFunctions {
    public static void printMenuOptions(Map<Integer, MenuOption> menu, String info){
        printBanner(info);
        menu.forEach((key, value) -> System.out.println(key + ". " + value.getOptionName()));
        System.out.println(line);
    }

    public static void printOptions(Map<Integer, MenuOption> menu){
        System.out.println(line);
        menu.forEach((key, value) -> System.out.println(key + ". " + value.getOptionName()));
        System.out.println(line);
    }

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
