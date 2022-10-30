package com.kbilyk.menu.createBouquet;

import com.kbilyk.menu.MenuOption;

public class ChangeBoquet implements MenuOption {
    private final String name = "Change bouquet";

    @Override
    public void execute() {
        System.out.println("Changing bouquet...");

    }

    @Override
    public String getOptionName() {
        return name;
    }
}
