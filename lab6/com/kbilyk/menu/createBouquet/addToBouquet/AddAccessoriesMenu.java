package com.kbilyk.menu.createBouquet.addToBouquet;

import com.kbilyk.menu.createBouquet.PrintAvailableAccessoriesOption;
import com.kbilyk.menu.exit.BackToPrevOption;
import com.kbilyk.menu.MenuOption;
import com.kbilyk.menu.sortFilterMenu.sortFilterAccessoryMenu.SortFilterAccessoryMenu;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.kbilyk.inputOutput.MakeBeautyOutput.printBanner;
import static com.kbilyk.menu.MenuFunctions.executeOption;
import static com.kbilyk.menu.MenuFunctions.printOptions;
import static com.kbilyk.sortfilter.FilterAccessoriesWithEntering.filteredAccessories;


public class AddAccessoriesMenu implements MenuOption {
    private Map<Integer, MenuOption> addAccessoryMenu;

    public AddAccessoriesMenu(){

        addAccessoryMenu = new LinkedHashMap<>();

        addAccessoryMenu.put(0, new BackToPrevOption());

    }

    @Override
    public void execute(){

        SortFilterAccessoryMenu sortFilterAccessoryMenu = new SortFilterAccessoryMenu();
        sortFilterAccessoryMenu.execute();
        if(!filteredAccessories.isEmpty()){
            addAccessoryMenu.put(1, new AddAccessoryOption());
            addAccessoryMenu.put(2, new PrintAvailableAccessoriesOption());
        }

        new PrintAvailableAccessoriesOption().execute();

        while(true){
            if(filteredAccessories.isEmpty()){
                addAccessoryMenu.remove(1);
                addAccessoryMenu.remove(2);
                printBanner("No accessories to add!");
            }
            printOptions(addAccessoryMenu);

            if(executeOption(addAccessoryMenu).getClass() == BackToPrevOption.class){
                return;
            }
        }
    }

    @Override
    public String getOptionName() {
        return "Add accessories";
    }
}
