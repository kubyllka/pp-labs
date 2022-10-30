package com.kbilyk;

import com.kbilyk.сonstant.FlowerType;

import java.util.LinkedList;

import static com.kbilyk.Assortment.flowers;
import static com.kbilyk.Error.enterCorrectInt;
import static com.kbilyk.сonstant.FlowerType.getFlowerType;
import static com.kbilyk.сonstant.FlowerType.printFlowerType;

public class FilterFlower {

    static public LinkedList<Flower> filteredFlowers = flowers;

    public static void sortFlowersByType(){
        printFlowerType();
        getFlowerType();

    }

    public static void sortFlowersByPrice(){
        System.out.println("\nFiltred by price");
    }

    public static void sortFlowersByLength(){
        System.out.println("\nFiltred by length");
    }

    public static void sortFlowersByFresh(){
        System.out.println("\nFiltred by length");
    }

    public static void refreshFilteredFlowers(){
        System.out.println("\nRefresh flowers");
    }

    public static void printFilteredFlowers(){
        System.out.println("\nFiltered flowers here:");

    }
}
