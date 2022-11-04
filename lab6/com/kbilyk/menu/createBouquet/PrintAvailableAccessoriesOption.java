package com.kbilyk.menu.createBouquet;

import com.kbilyk.menu.MenuOption;

import static com.kbilyk.sortfilter.FilterAccessoriesWithEntering.printFilteredAccessories;

public class PrintAvailableAccessoriesOption implements MenuOption {

    @Override
    public void execute() {
        printFilteredAccessories();
    }

    @Override
    public String getOptionName() {
        return "Print available accessories from search list";
    }
}
