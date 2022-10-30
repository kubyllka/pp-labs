package com.kbilyk.menu.changeAssortment;

import com.kbilyk.menu.MenuOption;

public class AddNewFlower implements MenuOption {
    private final String name = "Add new flower";
    @Override
    public void execute() {
        System.out.println("Adding new flower...");
    }

    @Override
    public String getOptionName() {
        return name;
    }
}
