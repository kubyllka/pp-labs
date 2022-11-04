package com.kbilyk.menu.changeAssortment.deleteAssortment;

import com.kbilyk.menu.MenuOption;
import com.kbilyk.menu.createBouquet.PrintAvailableAccessoriesOption;
import com.kbilyk.menu.exit.BackToPrevOption;
import com.kbilyk.menu.sortFilterMenu.sortFilterAccessoryMenu.SortFilterAccessoryMenu;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.kbilyk.inputOutput.MakeBeautyOutput.printBanner;
import static com.kbilyk.menu.MenuFunctions.executeOption;
import static com.kbilyk.menu.MenuFunctions.printOptions;
import static com.kbilyk.sortfilter.FilterAccessoriesWithEntering.filteredAccessories;


public class DeleteAccessoriesMenu implements MenuOption {

    private Map<Integer, MenuOption> deleteAccessoryMenu;

    public DeleteAccessoriesMenu() {

        deleteAccessoryMenu = new LinkedHashMap<>();

        deleteAccessoryMenu.put(0, new BackToPrevOption());
    }


    @Override
    public void execute() {

        SortFilterAccessoryMenu sortFilterAccessoryMenu = new SortFilterAccessoryMenu();
        sortFilterAccessoryMenu.execute();
        if(!filteredAccessories.isEmpty()){
            deleteAccessoryMenu.put(1, new DeleteAccessoryOption());
            deleteAccessoryMenu.put(2, new PrintAvailableAccessoriesOption());
        }

        new PrintAvailableAccessoriesOption().execute();

        while(true){

            if(filteredAccessories.isEmpty()){
                deleteAccessoryMenu.remove(1);
                deleteAccessoryMenu.remove(2);
                printBanner("No flowers to delete!");
            }

            printOptions(deleteAccessoryMenu);

            if(executeOption(deleteAccessoryMenu).getClass() == BackToPrevOption.class){
                return;
            }
        }
    }

    @Override
    public String getOptionName() {
        return "Delete accessory";
    }
}
