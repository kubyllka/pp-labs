package com.kbilyk.menu.createBouquet;

import com.kbilyk.menu.MenuOption;
import com.kbilyk.menu.createBouquet.deleteFromBouquet.DeleteFlowerBouqMenu;
import com.kbilyk.menu.createBouquet.deleteFromBouquet.DeleteAccessoriesBouqMenu;
import com.kbilyk.menu.createBouquet.printBouquetInfo.PrintInfoBouqOption;
import com.kbilyk.menu.exit.BackToPrevOption;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.kbilyk.menu.MenuFunctions.executeOption;
import static com.kbilyk.menu.MenuFunctions.printMenuOptions;


public class ChangeBouquetMenu implements MenuOption {

    private Map<Integer, MenuOption> changeBouqOptions;

    public ChangeBouquetMenu() {

        changeBouqOptions = new LinkedHashMap<>();

        changeBouqOptions.put(1, new DeleteAccessoriesBouqMenu());

        changeBouqOptions.put(2, new DeleteFlowerBouqMenu());

        changeBouqOptions.put(3, new PrintInfoBouqOption());

        changeBouqOptions.put(0, new BackToPrevOption());
    }

    @Override
    public void execute() {
        while(true){
            printMenuOptions(changeBouqOptions, "Change bouquet menu" );
            if (executeOption(changeBouqOptions).getClass() == BackToPrevOption.class){
                break;
            }
        }
    }

    @Override
    public String getOptionName() {
        return "Change bouquet";
    }
}
