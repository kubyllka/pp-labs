package com.kbilyk.menu.printAssortment.printAccessories;

import com.kbilyk.Error;
import com.kbilyk.menu.MenuOption;
import com.kbilyk.menu.exit.BackToPrev;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class PrintAccessories implements MenuOption {

    private Map<Integer, MenuOption> printAccessoryMenu;
    private static String name = "Print accessories";

    public PrintAccessories() {
        printAccessoryMenu = new LinkedHashMap<>();

        printAccessoryMenu.put(1, new TypeFilterAccessory());

        printAccessoryMenu.put(2, new PriceFilterAccessory());

        printAccessoryMenu.put(3, new PrintAllAccessory());

        printAccessoryMenu.put(4, new BackToPrev());
    }

    public MenuOption executeOption(){

        System.out.println("Choose option:");
        int numOption = Error.enterCorrectInt();

        if(printAccessoryMenu.get(numOption) != null){
            printAccessoryMenu.get(numOption).execute();
        }
        else{
            System.out.println("Oooops... Incorrect option. Try again");
            return executeOption();
        }
        return  printAccessoryMenu.get(numOption);
    }

    @Override
    public void execute() {

        while (true){
            printOptions();
            if(executeOption().getClass() == BackToPrev.class){
                return;
            }
        }
    }

    public void printOptions(){
        System.out.println("\n-----------------------------");
        System.out.println("Accessory filter Menu");
        System.out.println("-----------------------------");
        printAccessoryMenu.forEach((key, value) -> System.out.println(key + ". " + value.getOptionName()));
        System.out.println("-----------------------------");
    }
    @Override
    public String getOptionName() {
        return name;
    }
}
