package com.kbilyk.menu.sortFilterMenu.sortFilterFlowerMenu;

import com.kbilyk.menu.MenuOption;

import static com.kbilyk.sortfilter.FilterFlowersWithEntering.filterAllFlowers;

public class AllFlowersOption implements MenuOption {
    @Override
    public void execute() {
        filterAllFlowers();
    }

    @Override
    public String getOptionName() {
        return "All flowers";
    }
}
