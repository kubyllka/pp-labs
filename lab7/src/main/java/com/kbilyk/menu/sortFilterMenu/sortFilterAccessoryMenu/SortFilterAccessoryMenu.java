package com.kbilyk.menu.sortFilterMenu.sortFilterAccessoryMenu;
import com.kbilyk.menu.MenuOption;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.kbilyk.menu.MenuFunctions.executeOption;
import static com.kbilyk.menu.MenuFunctions.printMenuOptions;


public class SortFilterAccessoryMenu {

    private Map<Integer, MenuOption> sortFilterAccessoryMenu;

    public SortFilterAccessoryMenu() {

        sortFilterAccessoryMenu = new LinkedHashMap<>();

        sortFilterAccessoryMenu.put(1, new FilterTypeAccessoryOption());

        sortFilterAccessoryMenu.put(2, new FilterPriceAccessoryOption());

        sortFilterAccessoryMenu.put(3, new AllAccessoriesOption());
    }

    public void execute() {
        printMenuOptions(sortFilterAccessoryMenu, "Accessory filter menu");
        executeOption(sortFilterAccessoryMenu);
    }
}
