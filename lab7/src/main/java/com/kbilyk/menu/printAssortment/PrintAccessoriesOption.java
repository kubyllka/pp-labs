package com.kbilyk.menu.printAssortment;

import com.kbilyk.menu.MenuOption;
import com.kbilyk.menu.sortFilterMenu.sortFilterAccessoryMenu.SortFilterAccessoryMenu;

import static com.kbilyk.sortfilter.FilterAccessoriesWithEntering.printFilteredAccessories;

public class PrintAccessoriesOption implements MenuOption {

    @Override
    public void execute(){

        SortFilterAccessoryMenu sortFilterAccessoryMenu = new SortFilterAccessoryMenu();
        sortFilterAccessoryMenu.execute();
        printFilteredAccessories();

    }

    @Override
    public String getOptionName() {
        return "Print accessories";
    }
}
