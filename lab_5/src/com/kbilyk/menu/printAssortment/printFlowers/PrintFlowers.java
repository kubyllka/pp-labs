package com.kbilyk.menu.printAssortment.printFlowers;

import com.kbilyk.Error;
import com.kbilyk.menu.MenuOption;
import com.kbilyk.menu.exit.BackToPrev;

import java.awt.*;
import java.util.*;

public class PrintFlowers implements MenuOption {
    private Map<Integer, MenuOption> printFlowersMenu;

    private final String name = "Print flowers";

    public PrintFlowers() {

        printFlowersMenu = new LinkedHashMap<>();

        printFlowersMenu.put(1, new TypeFilterFlower());

        printFlowersMenu.put(2, new PriceFilterFlower());

        printFlowersMenu.put(3, new LengthFilterFlower());

        printFlowersMenu.put(4, new FreshFilterFlower());

        printFlowersMenu.put(5, new PrintAllFlowers());

        printFlowersMenu.put(6, new BackToPrev());
    }

    public MenuOption executeOption(){

        System.out.println("Choose option:");
        int numOption = Error.enterCorrectInt();

        if(printFlowersMenu.get(numOption) != null){
            printFlowersMenu.get(numOption).execute();
        }
        else{
            System.out.println("Oooops... Incorrect option. Try again");
            return executeOption();
        }
        return  printFlowersMenu.get(numOption);
    }
    @Override
    public void execute() {

        while (true){
            printOptions();
            if (executeOption().getClass() == BackToPrev.class)
                return;
        }
    }

    @Override
    public String getOptionName() {
        return name;
    }
    public void printOptions(){
        System.out.println("\n-----------------------------");
        System.out.println("Flowers filter Menu");
        System.out.println("-----------------------------");
        printFlowersMenu.forEach((key, value) -> System.out.println(key + ". " + value.getOptionName()));
        System.out.println("-----------------------------");
    }
}
