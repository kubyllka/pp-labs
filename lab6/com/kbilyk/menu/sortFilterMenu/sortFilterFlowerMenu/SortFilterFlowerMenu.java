package com.kbilyk.menu.sortFilterMenu.sortFilterFlowerMenu;

import com.kbilyk.menu.MenuOption;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.kbilyk.menu.MenuFunctions.executeOption;
import static com.kbilyk.menu.MenuFunctions.printMenuOptions;


public class SortFilterFlowerMenu {

    private Map<Integer, MenuOption> sortFilterFlowerMenu;

    public SortFilterFlowerMenu(){

        sortFilterFlowerMenu = new LinkedHashMap<>();

        sortFilterFlowerMenu.put(1, new FilterTypeFlowerOption());

        sortFilterFlowerMenu.put(2, new FilterPriceFlowerOption());

        sortFilterFlowerMenu.put(3, new FilterLengthFlowerOption());

        sortFilterFlowerMenu.put(4, new SortByFreshFlowerOption());

        sortFilterFlowerMenu.put(5, new AllFlowersOption());

    }

    public void execute() {
        printMenuOptions(sortFilterFlowerMenu,"Flowers filter menu");
        executeOption(sortFilterFlowerMenu);
    }
}
