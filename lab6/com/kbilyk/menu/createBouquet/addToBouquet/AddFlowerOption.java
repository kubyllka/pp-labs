package com.kbilyk.menu.createBouquet.addToBouquet;

import com.kbilyk.menu.MenuOption;

import static com.kbilyk.Bouquet.addFlowerFromFilteredList;



public class AddFlowerOption implements MenuOption {

    @Override
    public void execute() {
        addFlowerFromFilteredList();
    }

    @Override
    public String getOptionName() {
        return "Add flower from list";
    }

}
