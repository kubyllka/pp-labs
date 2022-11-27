package com.kbilyk.menu.createBouquet.printBouquetInfo;

import com.kbilyk.menu.MenuOption;
import static com.kbilyk.Bouquet.printBouquetInfo;

public class PrintInfoBouqOption implements MenuOption {

    @Override
    public void execute() {
        printBouquetInfo();
    }

    @Override
    public String getOptionName() {
        return "Print info about this bouquet";
    }
}
