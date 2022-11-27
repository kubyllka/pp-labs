package com.kbilyk.menu.sortFilterMenu.sortFilterFlowerMenu;

import com.kbilyk.menu.MenuOption;

import static com.kbilyk.sortfilter.FilterFlowersWithEntering.filterFlowersInPriceRange;

public class FilterPriceFlowerOption implements MenuOption {
    @Override
    public void execute() { filterFlowersInPriceRange();}

    @Override
    public String getOptionName() {
        return "Filter flowers in price range";
    }
}
