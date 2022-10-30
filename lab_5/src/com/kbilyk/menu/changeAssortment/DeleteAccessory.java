package com.kbilyk.menu.changeAssortment;

import com.kbilyk.menu.MenuOption;

public class DeleteAccessory implements MenuOption {

    private final String name = "Delete accessory";
    @Override
    public void execute() {
        System.out.println("Deleting accessory");
    }

    @Override
    public String getOptionName() {
        return name;
    }
}
