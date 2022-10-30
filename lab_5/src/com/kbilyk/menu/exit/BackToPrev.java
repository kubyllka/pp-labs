package com.kbilyk.menu.exit;

import com.kbilyk.menu.MenuOption;

public class BackToPrev implements MenuOption {
    private final String name = "Back";

    @Override
    public void execute() {}
    @Override
    public String getOptionName() {
        return name;
    }
}
