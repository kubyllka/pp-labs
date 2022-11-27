package com.kbilyk.menu.createBouquet.addToBouquet;

import com.kbilyk.menu.createBouquet.PrintAvailableFlowersOption;
import com.kbilyk.menu.exit.BackToPrevOption;
import com.kbilyk.menu.MenuOption;
import com.kbilyk.menu.sortFilterMenu.sortFilterFlowerMenu.SortFilterFlowerMenu;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.kbilyk.inputOutput.MakeBeautyOutput.printBanner;
import static com.kbilyk.menu.MenuFunctions.executeOption;
import static com.kbilyk.menu.MenuFunctions.printOptions;
import static com.kbilyk.sortfilter.FilterFlowersWithEntering.filteredFlowers;

public class AddFlowersMenu implements MenuOption {

    private Map<Integer, MenuOption> addFlowerMenu;

    public AddFlowersMenu(){

        addFlowerMenu = new LinkedHashMap<>();

        addFlowerMenu.put(0, new BackToPrevOption());

    }

    @Override
    public void execute() {

        SortFilterFlowerMenu sortFilterFlowerMenu = new SortFilterFlowerMenu();
        sortFilterFlowerMenu.execute();
        if (!filteredFlowers.isEmpty()) {
            addFlowerMenu.put(1, new AddFlowerOption());
            addFlowerMenu.put(2, new PrintAvailableFlowersOption());
        }

        new PrintAvailableFlowersOption().execute();

        while (true) {
            if (filteredFlowers.isEmpty()) {
                addFlowerMenu.remove(1);
                addFlowerMenu.remove(2);
                printBanner("No flowers to add!");
            }
            printOptions(addFlowerMenu);

            if (executeOption(addFlowerMenu).getClass() == BackToPrevOption.class) {
                return;
            }
        }
    }

    @Override
    public String getOptionName() {
        return "Add flowers";
    }
}
