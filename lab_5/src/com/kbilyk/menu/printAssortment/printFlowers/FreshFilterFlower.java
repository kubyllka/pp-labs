package com.kbilyk.menu.printAssortment.printFlowers;

import com.kbilyk.menu.MenuOption;

import static com.kbilyk.FilterFlower.printFilteredFlowers;
import static com.kbilyk.FilterFlower.sortFlowersByFresh;

public class FreshFilterFlower implements MenuOption {

    private static String name = "Add fresh filter";

    @Override
    public void execute() {

        sortFlowersByFresh();
        printFilteredFlowers();
    }

    @Override
    public String getOptionName() {
        return name;
    }
}
