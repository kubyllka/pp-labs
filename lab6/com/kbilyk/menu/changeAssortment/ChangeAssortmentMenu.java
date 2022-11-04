package com.kbilyk.menu.changeAssortment;


import com.kbilyk.menu.MenuOption;
import com.kbilyk.menu.changeAssortment.addAssortment.AddNewAccessoryOption;
import com.kbilyk.menu.changeAssortment.addAssortment.AddNewFlowerOption;
import com.kbilyk.menu.changeAssortment.deleteAssortment.DeleteAccessoriesMenu;
import com.kbilyk.menu.changeAssortment.deleteAssortment.DeleteFlowersMenu;
import com.kbilyk.menu.exit.BackToPrevOption;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.kbilyk.menu.MenuFunctions.executeOption;
import static com.kbilyk.menu.MenuFunctions.printMenuOptions;


public class ChangeAssortmentMenu implements MenuOption {

    private Map<Integer, MenuOption> changeAssortmentMenu;

    public ChangeAssortmentMenu() {

        changeAssortmentMenu = new LinkedHashMap<>();

        changeAssortmentMenu.put(1, new AddNewFlowerOption());

        changeAssortmentMenu.put(2, new AddNewAccessoryOption());

        changeAssortmentMenu.put(3, new DeleteFlowersMenu());

        changeAssortmentMenu.put(4, new DeleteAccessoriesMenu());

        changeAssortmentMenu.put(5, new BackToPrevOption());
    }

    @Override
    public void execute() {
        do {
            printMenuOptions(changeAssortmentMenu, "Change assortment menu");
        } while (executeOption(changeAssortmentMenu).getClass() != BackToPrevOption.class);
    }

    @Override
    public String getOptionName() {
        return "Change assortment";
    }
}
