package com.kbilyk.menu.createBouquet;

import com.kbilyk.menu.MenuOption;

import static com.kbilyk.Bouquet.buyBouquetDAO;


public class BuyThisBouquetOption implements MenuOption {

    @Override
    public void execute() {
        buyBouquetDAO();
    }

    @Override
    public String getOptionName() {
        return "Buy this bouquet";
    }
}
