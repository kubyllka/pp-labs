package com.kbilyk;

import java.util.LinkedList;

import static com.kbilyk.сonstant.AccessoryType.getAccessoryType;
import static com.kbilyk.сonstant.AccessoryType.printAccessoryType;
import static com.kbilyk.сonstant.FlowerType.getFlowerType;
import static com.kbilyk.сonstant.FlowerType.printFlowerType;

public class FilterAccessory {

    static public LinkedList<Flower> filteredAccessories = new LinkedList<>();

    public static void sortAccessoryByType(){
        System.out.println("\nFiltred by type");
    }

    public static void sortAccessoryByPrice(){
        System.out.println("\nFiltred by price");
    }

    public static void printFilteredAccessory(){
        printAccessoryType();
        getAccessoryType();
    }
}
