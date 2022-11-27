package com.kbilyk.menu.createBouquet;

import com.kbilyk.menu.*;
import com.kbilyk.menu.createBouquet.addToBouquet.AddAccessoriesMenu;
import com.kbilyk.menu.createBouquet.addToBouquet.AddFlowersMenu;
import com.kbilyk.menu.createBouquet.printBouquetInfo.PrintInfoBouqOption;
import com.kbilyk.menu.exit.BackToPrevOption;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.kbilyk.Bouquet.refreshBouquet;
import static com.kbilyk.menu.MenuFunctions.executeOption;
import static com.kbilyk.menu.MenuFunctions.printMenuOptions;


public class CreateBouquetMenu implements MenuOption {

    private Map<Integer, MenuOption> createBouqOptions;


    public CreateBouquetMenu(){

        createBouqOptions = new LinkedHashMap<>();

        createBouqOptions.put(1, new AddFlowersMenu());

        createBouqOptions.put(2, new AddAccessoriesMenu());

        createBouqOptions.put(3, new ChangeBouquetMenu());

        createBouqOptions.put(4, new PrintInfoBouqOption());

        createBouqOptions.put(5, new BuyThisBouquetOption());

        createBouqOptions.put(6, new BackToPrevOption());

    }


    @Override
    public void execute(){

        while(true){
            printMenuOptions(createBouqOptions,"Creator of bouquet");
            if(executeOption(createBouqOptions).getClass() == BackToPrevOption.class){
                refreshBouquet();
                return;
            }
        }
    }

    @Override
    public String getOptionName() {
        return "Create bouquet";
    }
}
