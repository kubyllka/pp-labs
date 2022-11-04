package com.kbilyk.menu.createBouquet.deleteFromBouquet;

import com.kbilyk.menu.MenuOption;

import static com.kbilyk.Bouquet.deleteAccessoryFromBouq;

public class DeleteAccessoryBouqOption implements MenuOption {

    @Override
    public void execute() {
        deleteAccessoryFromBouq();
    }

    @Override
    public String getOptionName() {
        return "Delete accessory from list";
    }
}
