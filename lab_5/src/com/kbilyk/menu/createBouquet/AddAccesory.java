package com.kbilyk.menu.createBouquet;

import com.kbilyk.Bouquet;
import com.kbilyk.menu.MenuOption;

import static com.kbilyk.Error.enterCorrectInt;
import static com.kbilyk.FilterAccessory.filteredAccessories;


public class AddAccesory implements MenuOption {
    private final String name = "Add accessory from list";

    @Override
    public void execute() {

        System.out.println("Type the correct index of accessory:");
        int num = enterCorrectInt();
        if(filteredAccessories.get(num) == null){
            execute();
        }
        else{
            Bouquet.bouquetAccessory.add(filteredAccessories.get(num));
        }
    }

    @Override
    public String getOptionName() {
        return name;
    }
}
