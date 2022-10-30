package com.kbilyk.menu.printAssortment.printFlowers;

import com.kbilyk.menu.MenuOption;
import com.kbilyk.сonstant.FlowerType;


import static com.kbilyk.Assortment.flowers;
import static com.kbilyk.Error.enterCorrectInt;
import static com.kbilyk.FilterFlower.printFilteredFlowers;
import static com.kbilyk.FilterFlower.sortFlowersByType;
import static com.kbilyk.сonstant.FlowerType.getFlowerType;
import static com.kbilyk.сonstant.FlowerType.printFlowerType;

public class TypeFilterFlower implements MenuOption {

    private final String name = "Add type filter";

    @Override
    public void execute() {
        sortFlowersByType();
        printFilteredFlowers();
    }

    @Override
    public String getOptionName() {
        return name;
    }
}
