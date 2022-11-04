package com.kbilyk.menu.createBouquet.deleteFromBouquet;

import com.kbilyk.item.Flower;
import com.kbilyk.menu.MenuOption;
import com.kbilyk.menu.createBouquet.printBouquetInfo.PrintFlowersBouqOption;
import com.kbilyk.menu.exit.BackToPrevOption;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import static com.kbilyk.Bouquet.bouquetFlowers;
import static com.kbilyk.inputOutput.MakeBeautyOutput.printBanner;
import static com.kbilyk.menu.MenuFunctions.executeOption;
import static com.kbilyk.menu.MenuFunctions.printOptions;

public class DeleteFlowerBouqMenu implements MenuOption {

    private Map<Integer, MenuOption> deleteFlowerFromBouq;
    public DeleteFlowerBouqMenu(){

        deleteFlowerFromBouq = new LinkedHashMap<>();

        deleteFlowerFromBouq.put(0, new BackToPrevOption());

    }

    @Override
    public void execute() {
        if(!bouquetFlowers.isEmpty()){
            deleteFlowerFromBouq.put(1, new DeleteFlowerBouqOption());
            deleteFlowerFromBouq.put(2, new PrintFlowersBouqOption());
        }
        new PrintFlowersBouqOption().execute();

        while(true) {
            if(bouquetFlowers.isEmpty()){
                deleteFlowerFromBouq.remove(1);
                deleteFlowerFromBouq.remove(2);
                printBanner("No flowers to delete!");
            }

            printOptions(deleteFlowerFromBouq);

            if(executeOption(deleteFlowerFromBouq).getClass() == BackToPrevOption.class){
                return;
            }
        }
    }

    @Override
    public String getOptionName() {
        return "Delete flower from bouquet";
    }
}
