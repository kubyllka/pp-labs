package com.kbilyk.menu.createBouquet;

import com.kbilyk.menu.MenuOption;

import static com.kbilyk.sortfilter.FilterFlowersWithEntering.printFilteredFlowers;

public class PrintAvailableFlowersOption implements MenuOption {

    @Override
    public void execute() {
        printFilteredFlowers();
    }

    @Override
    public String getOptionName() {
        return "Print available flowers from search list";
    }
}
