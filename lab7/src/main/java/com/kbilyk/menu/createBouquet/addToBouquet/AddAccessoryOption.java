package com.kbilyk.menu.createBouquet.addToBouquet;

import com.kbilyk.menu.MenuOption;

import static com.kbilyk.Bouquet.addAccessoryFromFilteredList;

public class AddAccessoryOption implements MenuOption {

    @Override
    public void execute() { addAccessoryFromFilteredList();}

    @Override
    public String getOptionName() {
        return "Add accessory from list";
    }
}
