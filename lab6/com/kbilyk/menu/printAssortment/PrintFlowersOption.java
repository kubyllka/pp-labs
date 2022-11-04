package com.kbilyk.menu.printAssortment;

import com.kbilyk.menu.MenuOption;
import com.kbilyk.menu.sortFilterMenu.sortFilterFlowerMenu.SortFilterFlowerMenu;

import static com.kbilyk.sortfilter.FilterFlowersWithEntering.printFilteredFlowers;

public class PrintFlowersOption implements MenuOption {

    @Override
    public void execute(){

        SortFilterFlowerMenu sortFilterFlowerMenu = new SortFilterFlowerMenu();
        sortFilterFlowerMenu.execute();
        printFilteredFlowers();

    }

    @Override
    public String getOptionName() {
        return "Print flowers";
    }

}
