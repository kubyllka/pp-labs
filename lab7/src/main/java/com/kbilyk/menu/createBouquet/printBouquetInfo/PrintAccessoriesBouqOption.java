package com.kbilyk.menu.createBouquet.printBouquetInfo;

import com.kbilyk.menu.MenuOption;

import static com.kbilyk.Bouquet.printBouquetAccessories;

public class PrintAccessoriesBouqOption implements MenuOption {

    @Override
    public void execute() {
        printBouquetAccessories();
    }

    @Override
    public String getOptionName() {
        return "Print the list of accessories in bouquet";
    }
}
