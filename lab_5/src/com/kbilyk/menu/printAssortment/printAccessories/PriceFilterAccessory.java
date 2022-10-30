package com.kbilyk.menu.printAssortment.printAccessories;

import com.kbilyk.menu.MenuOption;

import static com.kbilyk.FilterAccessory.printFilteredAccessory;
import static com.kbilyk.FilterAccessory.sortAccessoryByPrice;

public class PriceFilterAccessory implements MenuOption {
    private static String name = "Add price filter";

    @Override
    public void execute() {
        sortAccessoryByPrice();
        printFilteredAccessory();
    }

    @Override
    public String getOptionName() {
        return name;
    }
}
