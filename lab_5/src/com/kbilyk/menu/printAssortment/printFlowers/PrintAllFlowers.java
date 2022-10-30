package com.kbilyk.menu.printAssortment.printFlowers;

import com.kbilyk.menu.MenuOption;

import static com.kbilyk.Assortment.flowers;

public class PrintAllFlowers implements MenuOption {

    private final String name = "Print all flowers";

    @Override
    public void execute() {
        System.out.println(flowers);
    }

    @Override
    public String getOptionName() {
        return name;
    }
}
