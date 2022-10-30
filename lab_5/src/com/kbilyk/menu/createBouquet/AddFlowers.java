package com.kbilyk.menu.createBouquet;

import com.kbilyk.Error;
import com.kbilyk.menu.exit.BackToPrev;
import com.kbilyk.menu.MenuOption;
import com.kbilyk.menu.printAssortment.printFlowers.PrintFlowers;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class AddFlowers implements MenuOption {

    private Map<Integer, MenuOption> addFlowerMenu;
    private final String name = "Add Flowers";
    AddFlowers(){
        addFlowerMenu = new LinkedHashMap<>();

        addFlowerMenu.put(1, new AddFlower());
        addFlowerMenu.put(0, new BackToPrev());

    }

    public MenuOption executeOption(){

        System.out.println("Choose option:");
        int numOption = Error.enterCorrectInt();

        if(addFlowerMenu.get(numOption) != null){
            addFlowerMenu.get(numOption).execute();
        }
        else{
            System.out.println("Oooops... Incorrect option. Try again");
            return executeOption();
        }
        return addFlowerMenu.get(numOption);
    }
    @Override
    public void execute() {
        while(true){
            PrintFlowers print = new PrintFlowers();
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
        addFlowerMenu.forEach((key, value) -> System.out.println(key + ". " + value.getOptionName()));
        System.out.println("-----------------------------");
    }

    @Override
    public String getOptionName() {
        return name;
    }
}
