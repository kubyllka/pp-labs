package com.kbilyk.menu.sortFilterMenu.sortFilterFlowerMenu;

import com.kbilyk.menu.MenuOption;

import static com.kbilyk.sortfilter.FilterFlowersWithEntering.filterFlowersInLengthRange;

public class FilterLengthFlowerOption implements MenuOption {
    @Override
    public void execute() { filterFlowersInLengthRange();}

    @Override
    public String getOptionName() {
        return "Filter flowers in length range";
    }
}
