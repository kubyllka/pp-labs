package com.kbilyk.menu.createBouquet;



import com.kbilyk.Bouquet;
import com.kbilyk.menu.MenuOption;

import static com.kbilyk.Error.enterCorrectInt;
import static com.kbilyk.FilterFlower.filteredFlowers;


public class AddFlower implements MenuOption {

    private final String name = "Add flower from list";

    @Override
    public void execute() {

        System.out.println("Type the correct index of flower:");
        int num = enterCorrectInt();
        if(filteredFlowers.get(num) == null){
            execute();
        }
        else{
            Bouquet.bouquetFlowers.add(filteredFlowers.get(num));
        }
    }

    @Override
    public String getOptionName() {
        return name;
    }
}
