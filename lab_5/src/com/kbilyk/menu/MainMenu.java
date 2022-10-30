package com.kbilyk.menu;

import com.kbilyk.Error;
import com.kbilyk.menu.changeAssortment.ChangeAssortment;
import com.kbilyk.menu.createBouquet.CreateBouquet;
import com.kbilyk.menu.exit.ExitOption;
import com.kbilyk.menu.printAssortment.PrintAssortment;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The main menu of the program which execute all possible methods in
 * program
 */
public class MainMenu {

    private Map<Integer, MenuOption> menuOptions;

    public MainMenu() {

        menuOptions = new LinkedHashMap<>();

        menuOptions.put(1, new CreateBouquet());

        menuOptions.put(2, new PrintAssortment());

        menuOptions.put(3, new ChangeAssortment());

        menuOptions.put(4, new ExitOption());

    }

    public void execute(){
        System.out.println("Choose option:");
        int numOption = Error.enterCorrectInt();

        if(menuOptions.get(numOption) != null){
            menuOptions.get(numOption).execute();
        }
        else{
            System.out.println("Oooops... Incorrect option. Try again");
        }
    }


    public void printOptions(){
        System.out.println("\n-----------------------------");
        System.out.println("Main menu");
        System.out.println("-----------------------------");
        menuOptions.forEach((key, value) -> System.out.println(key + ". " + value.getOptionName()));
        System.out.println("-----------------------------");
    }
}
