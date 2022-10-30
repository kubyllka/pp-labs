package com.kbilyk.menu.printAssortment.printFlowers;

import com.kbilyk.menu.MenuOption;

import static com.kbilyk.FilterFlower.printFilteredFlowers;
import static com.kbilyk.FilterFlower.sortFlowersByLength;

public class LengthFilterFlower implements MenuOption {

    private static String name = "Add length filter";

    @Override
    public void execute() {
        sortFlowersByLength();
        printFilteredFlowers();
    }

    @Override
    public String getOptionName() {
        return name;
    }
}
