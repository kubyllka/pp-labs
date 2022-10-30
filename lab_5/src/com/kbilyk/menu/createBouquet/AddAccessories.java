package com.kbilyk.menu.createBouquet;

import com.kbilyk.Error;
import com.kbilyk.menu.exit.BackToPrev;
import com.kbilyk.menu.MenuOption;
import com.kbilyk.menu.printAssortment.printAccessories.PrintAccessories;

import java.util.LinkedHashMap;
import java.util.Map;


public class AddAccessories implements MenuOption {
    private final String name = "Add Accessories";
    private Map<Integer, MenuOption> addAccessoryMenu;

    AddAccessories(){
        addAccessoryMenu = new LinkedHashMap<>();

        addAccessoryMenu.put(1, new AddAccesory());

        addAccessoryMenu.put(0, new BackToPrev());

    }

    public MenuOption executeOption(){
        System.out.println("Choose option:");
        int numOption = Error.enterCorrectInt();

        if(addAccessoryMenu.get(numOption) != null){
            addAccessoryMenu.get(numOption).execute();
        }
        else{
            System.out.println("Oooops... Incorrect option. Try again");
            return executeOption();
        }
        return addAccessoryMenu.get(numOption);
    }

    @Override
    public void execute() {
        while(true){
            PrintAccessories print = new PrintAccessories();

            print.printOptions();
            if(print.executeOption().getClass() == BackToPrev.class){
                return;
            }
            printOptions();
            if(executeOption().getClass() == BackToPrev.class){
                return;
            }
        }
    }

    public void printOptions(){

        System.out.println("-----------------------------");
        addAccessoryMenu.forEach((key, value) -> System.out.println(key + ". " + value.getOptionName()));
        System.out.println("-----------------------------");
    }


    @Override
    public String getOptionName() {
        return name;
    }
}
