package com.kbilyk.menu.printAssortment.printFlowers;

import com.kbilyk.menu.MenuOption;

import static com.kbilyk.FilterFlower.printFilteredFlowers;
import static com.kbilyk.FilterFlower.sortFlowersByPrice;

public class PriceFilterFlower implements MenuOption {

    private static String name = "Add price filter";
    @Override
    public void execute() {
        sortFlowersByPrice();
        printFilteredFlowers();
    }

    @Override
    public String getOptionName() {
        return name;
    }
}
