package com.kbilyk.menu.changeAssortment;

import com.kbilyk.menu.MenuOption;

public class DeleteFlower implements MenuOption {

    private final String name = "Delete flower";
    @Override
    public void execute() {
        System.out.println("Deleting flower...");
    }

    @Override
    public String getOptionName() {
        return name;
    }
}
