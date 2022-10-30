package com.kbilyk.menu.changeAssortment;

import com.kbilyk.menu.MenuOption;

public class AddNewAccessory implements MenuOption {
    private final String name = "Add new accessory";
    @Override
    public void execute() {
        System.out.println("Adding accessory...");
    }

    @Override
    public String getOptionName() {
        return name;
    }
}
