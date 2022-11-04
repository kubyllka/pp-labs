package com.kbilyk.menu.sortFilterMenu.sortFilterFlowerMenu;

import com.kbilyk.menu.MenuOption;

import static com.kbilyk.constant.OrderSort.getOrderSortType;
import static com.kbilyk.sortfilter.FilterFlowersWithEntering.sortFlowersByFresh;


public class SortByFreshFlowerOption implements MenuOption {
    @Override
    public void execute() {
        sortFlowersByFresh();
    }

    @Override
    public String getOptionName() {
        return "Sort flowers by fresh";
    }
}
