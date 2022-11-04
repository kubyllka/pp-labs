package com.kbilyk.menu.sortFilterMenu.sortFilterAccessoryMenu;

import com.kbilyk.menu.MenuOption;

import static com.kbilyk.sortfilter.FilterAccessoriesWithEntering.filterAccessInPriceRange;

public class FilterPriceAccessoryOption implements MenuOption {
    @Override
    public void execute() {
        filterAccessInPriceRange();
    }

    @Override
    public String getOptionName() {
        return "Filter accessories in price range";
    }
}
