package com.kbilyk.menu.createBouquet.deleteFromBouquet;

import com.kbilyk.menu.MenuOption;
import com.kbilyk.menu.createBouquet.printBouquetInfo.PrintAccessoriesBouqOption;
import com.kbilyk.menu.exit.BackToPrevOption;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import static com.kbilyk.Bouquet.bouquetAccessories;
import static com.kbilyk.inputOutput.MakeBeautyOutput.printBanner;
import static com.kbilyk.menu.MenuFunctions.executeOption;
import static com.kbilyk.menu.MenuFunctions.printOptions;

public class DeleteAccessoriesBouqMenu implements MenuOption {

    private Map<Integer, MenuOption> deleteAccessoryMenu;

    public DeleteAccessoriesBouqMenu() {
        deleteAccessoryMenu = new LinkedHashMap<>();

        deleteAccessoryMenu.put(0, new BackToPrevOption());
    }

    @Override
    public void execute() {

        if(!bouquetAccessories.isEmpty()){
            deleteAccessoryMenu.put(1, new DeleteAccessoryBouqOption());
            deleteAccessoryMenu.put(2, new PrintAccessoriesBouqOption());
        }
        new PrintAccessoriesBouqOption().execute();

        while(true) {
            if(bouquetAccessories.isEmpty()){
                deleteAccessoryMenu.remove(1);
                deleteAccessoryMenu.remove(2);
                printBanner("No accessories to delete!");
            }
            printOptions(deleteAccessoryMenu);

            if(executeOption(deleteAccessoryMenu).getClass() == BackToPrevOption.class){
                return;
            }
        }
    }



    @Override
    public String getOptionName() {
        return "Delete accessory from bouquet";
    }
}
