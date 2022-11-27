package com.kbilyk.menu.sortFilterMenu.sortFilterAccessoryMenu;

import com.kbilyk.menu.MenuOption;

import static com.kbilyk.sortfilter.FilterAccessoriesWithEntering.filterAllAccessories;

public class AllAccessoriesOption implements MenuOption {

    @Override
    public void execute() {
        filterAllAccessories();
    }

    @Override
    public String getOptionName() {
        return "All accessories";
    }
}
