package com.kbilyk.menu.createBouquet;

import com.kbilyk.Error;
import com.kbilyk.menu.*;
import com.kbilyk.menu.exit.BackToPrev;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class CreateBouquet implements MenuOption {

    private Map<Integer, MenuOption> createBouqOptions;
    private final String name = "Create bouquet";



    public CreateBouquet(){
        createBouqOptions = new LinkedHashMap<>();

        createBouqOptions.put(1, new AddFlowers());

        createBouqOptions.put(2, new AddAccessories());

        createBouqOptions.put(3, new ChangeBoquet());

        createBouqOptions.put(4, new BackToPrev());

    }

    public MenuOption executeOption(){

        System.out.println("Choose option:");
        int numOption = Error.enterCorrectInt();

        if(createBouqOptions.get(numOption) != null){
            createBouqOptions.get(numOption).execute();
        }
        else{
            System.out.println("Oooops... Incorrect option. Try again");
            return executeOption();
        }
        return createBouqOptions.get(numOption);
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
        System.out.println("Creator of bouquet");
        System.out.println("-----------------------------");
        createBouqOptions.forEach((key, value) -> System.out.println(key + ". " + value.getOptionName()));
        System.out.println("-----------------------------");
    }
    @Override
    public String getOptionName() {
        return name;
    }
}
