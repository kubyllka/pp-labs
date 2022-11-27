package com.kbilyk.menu.createBouquet.deleteFromBouquet;

import com.kbilyk.menu.MenuOption;

import static com.kbilyk.Bouquet.deleteFlowerFromBouq;

public class DeleteFlowerBouqOption implements MenuOption {
    @Override
    public void execute() {
        deleteFlowerFromBouq();
    }

    @Override
    public String getOptionName() {
        return "Delete flower from list";
    }
}
