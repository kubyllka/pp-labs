package com.kbilyk.menu.printAssortment.printAccessories;

import com.kbilyk.menu.MenuOption;

import static com.kbilyk.FilterAccessory.printFilteredAccessory;
import static com.kbilyk.FilterAccessory.sortAccessoryByType;

public class TypeFilterAccessory implements MenuOption {

    private static String name = "Add type filter";

    @Override
    public void execute() {
        sortAccessoryByType();
        printFilteredAccessory();
    }

    @Override
    public String getOptionName() {
        return name;
    }
}
