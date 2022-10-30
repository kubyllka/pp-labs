package com.kbilyk.menu.printAssortment.printAccessories;

import com.kbilyk.menu.MenuOption;

public class PrintAllAccessory implements MenuOption {
    private static String name = "Print all accessories";

    @Override
    public void execute() {
        System.out.println("All accessories...");
    }

    @Override
    public String getOptionName() {
        return name;
    }
}
