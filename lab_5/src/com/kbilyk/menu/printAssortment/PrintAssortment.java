package com.kbilyk.menu.printAssortment;


import com.kbilyk.Error;
import com.kbilyk.menu.MenuOption;
import com.kbilyk.menu.printAssortment.printAccessories.PrintAccessories;
import com.kbilyk.menu.printAssortment.printFlowers.PrintFlowers;
import com.kbilyk.menu.exit.BackToPrev;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class PrintAssortment implements MenuOption {

    private Map<Integer, MenuOption> assortmentMenu;
    private final String name = "Print assortment";

    public PrintAssortment() {

        assortmentMenu = new LinkedHashMap<>();

        assortmentMenu.put(1, new PrintFlowers());

        assortmentMenu.put(2, new PrintAccessories());

        assortmentMenu.put(3, new BackToPrev());
    }

    public MenuOption executeOption(){
        System.out.println("Choose option:");
        int numOption = Error.enterCorrectInt();

        if(assortmentMenu.get(numOption) != null){
            assortmentMenu.get(numOption).execute();
        }
        else{
            System.out.println("Oooops... Incorrect option. Try again");
            return executeOption();
        }
        return assortmentMenu.get(numOption);
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
        System.out.println("Assortment menu");
        System.out.println("-----------------------------");
        assortmentMenu.forEach((key, value) -> System.out.println(key + ". " + value.getOptionName()));
        System.out.println("-----------------------------");
    }

}
