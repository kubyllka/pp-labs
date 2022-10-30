package com.kbilyk.menu.changeAssortment;

import com.kbilyk.Error;
import com.kbilyk.menu.*;
import com.kbilyk.menu.exit.BackToPrev;

import java.util.LinkedHashMap;
import java.util.Map;

public class ChangeAssortment implements MenuOption {
    private final String name = "Change assortment";

    private Map<Integer, MenuOption> сhangeAssortmentMenu;

    public ChangeAssortment() {

        сhangeAssortmentMenu = new LinkedHashMap<>();

        сhangeAssortmentMenu.put(1, new AddNewFlower());

        сhangeAssortmentMenu.put(2, new AddNewAccessory());

        сhangeAssortmentMenu.put(3, new DeleteFlower());

        сhangeAssortmentMenu.put(4, new DeleteAccessory());

        сhangeAssortmentMenu.put(5, new BackToPrev());
    }

    public MenuOption executeOption(){

        System.out.println("Choose option:");
        int numOption = Error.enterCorrectInt();

        if(сhangeAssortmentMenu.get(numOption) != null){
            сhangeAssortmentMenu.get(numOption).execute();
        }
        else{
            System.out.println("Oooops... Incorrect option. Try again");
            return executeOption();
        }
        return сhangeAssortmentMenu.get(numOption);
    }

    @Override
    public void execute() {
        while(true){
            printOptions();
            if(executeOption().getClass() == BackToPrev.class){
                return;
            }
        }
    }



    public void printOptions(){
        System.out.println("\n-----------------------------");
        System.out.println("Change assortment menu");
        System.out.println("-----------------------------");
        сhangeAssortmentMenu.forEach((key, value) -> System.out.println(key + ". " + value.getOptionName()));
        System.out.println("-----------------------------");
    }
    @Override
    public String getOptionName() {
        return name;
    }
}
