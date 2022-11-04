package com.kbilyk.menu.sortFilterMenu.sortFilterAccessoryMenu;

import com.kbilyk.menu.MenuOption;

import static com.kbilyk.sortfilter.FilterAccessoriesWithEntering.filterAccessoriesByType;

public class FilterTypeAccessoryOption implements MenuOption {

    @Override
    public void execute() {
        filterAccessoriesByType();
    }

    @Override
    public String getOptionName() {
        return "Filter accessories by type";
    }
}
