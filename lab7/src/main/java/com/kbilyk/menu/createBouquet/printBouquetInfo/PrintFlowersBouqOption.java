package com.kbilyk.menu.createBouquet.printBouquetInfo;

import com.kbilyk.menu.MenuOption;

import static com.kbilyk.Bouquet.printBouquetFlowers;

public class PrintFlowersBouqOption implements MenuOption {

    @Override
    public void execute() {
        printBouquetFlowers();
    }

    @Override
    public String getOptionName() {
        return "Print the list of flowers in bouquet";
    }
}
