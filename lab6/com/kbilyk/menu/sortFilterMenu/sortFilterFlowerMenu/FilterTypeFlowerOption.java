package com.kbilyk.menu.sortFilterMenu.sortFilterFlowerMenu;

import com.kbilyk.menu.MenuOption;


import static com.kbilyk.sortfilter.FilterFlowersWithEntering.filterFlowersByType;

public class FilterTypeFlowerOption implements MenuOption {

    @Override
    public void execute() {
       filterFlowersByType();
    }

    @Override
    public String getOptionName() {
        return "Filter flowers by type";
    }
}
