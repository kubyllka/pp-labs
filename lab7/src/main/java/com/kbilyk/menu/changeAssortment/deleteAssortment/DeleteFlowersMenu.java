package com.kbilyk.menu.changeAssortment.deleteAssortment;

import com.kbilyk.menu.MenuOption;
import com.kbilyk.menu.createBouquet.PrintAvailableFlowersOption;
import com.kbilyk.menu.exit.BackToPrevOption;
import com.kbilyk.menu.sortFilterMenu.sortFilterFlowerMenu.SortFilterFlowerMenu;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.kbilyk.inputOutput.MakeBeautyOutput.printBanner;
import static com.kbilyk.menu.MenuFunctions.executeOption;
import static com.kbilyk.menu.MenuFunctions.printOptions;
import static com.kbilyk.sortfilter.FilterFlowersWithEntering.filteredFlowers;

public class DeleteFlowersMenu implements MenuOption {

    private Map<Integer, MenuOption> deleteFlowerMenu;

    public DeleteFlowersMenu() {
        deleteFlowerMenu = new LinkedHashMap<>();

        deleteFlowerMenu.put(0, new BackToPrevOption());
    }

    @Override
    public void execute() {

        SortFilterFlowerMenu sortFilterFlowerMenu = new SortFilterFlowerMenu();
        sortFilterFlowerMenu.execute();
        if(!filteredFlowers.isEmpty()){
            deleteFlowerMenu.put(1, new DeleteFlowerOption());
            deleteFlowerMenu.put(2, new PrintAvailableFlowersOption());
        }

        new PrintAvailableFlowersOption().execute();

        while(true){
            if(filteredFlowers.isEmpty()){
                deleteFlowerMenu.remove(1);
                deleteFlowerMenu.remove(2);
                printBanner("No flowers to delete!");
            }

            printOptions(deleteFlowerMenu);

            if(executeOption(deleteFlowerMenu).getClass() == BackToPrevOption.class){
                return;
            }
        }
    }

    @Override
    public String getOptionName() {
        return "Delete flower";
    }
}
