package com.kbilyk.sortfilter;

import com.kbilyk.item.Flower;
import com.kbilyk.inputOutput.InputControl;

import java.util.ArrayList;

import static com.kbilyk.Bouquet.bouquetFlowers;
import static com.kbilyk.inputOutput.MakeBeautyOutput.*;
import static com.kbilyk.constant.FlowerType.getFlowerType;
import static com.kbilyk.constant.OrderSort.getOrderSortType;


public class FilterFlowersWithEntering {

    // Static arraylist of current filtering/sorting of flowers
    public static ArrayList<Flower> filteredFlowers = new ArrayList<>();

    /**
     * The method that sorts all flowers in ascending or descending order of freshness that not in use
     * This method calls for the user to enter the sorting parameters
     * @return The list of all flowers in ascending or descending order of freshness
     */
    public static ArrayList<Flower> sortFlowersByFresh(){
        SortFilterFlowersDAO filtrationFlower = new SortFilterFlowersDAO();
        filteredFlowers = filtrationFlower.sortByFresh(getOrderSortType());
        filteredFlowers.removeAll(bouquetFlowers);
        return filteredFlowers;
    }

    /**
     * The method that returns all flowers that not in use
     * This method calls for the user to enter the filter parameters
     * @return The list of all flowers that not used
     */
    public static ArrayList<Flower> filterAllFlowers(){
        SortFilterFlowersDAO filtrationFlower = new SortFilterFlowersDAO();
        filteredFlowers = filtrationFlower.getAll();
        filteredFlowers.removeAll(bouquetFlowers);
        return filteredFlowers;
    }

    /**
     * The method that searches for flowers of a given type that not in use
     * This method calls for the user to enter the filter parameters
     * @return The list of flowers of a given type that not in use
     */
    public static ArrayList<Flower> filterFlowersByType(){
        SortFilterFlowersDAO filtrationFlower = new SortFilterFlowersDAO();
        filteredFlowers = filtrationFlower.sortByType(getFlowerType());
        filteredFlowers.removeAll(bouquetFlowers);
        return filteredFlowers;
    }

    /**
     * The method that searches for flowers in a price range that on in use
     * The method asks the user to enter the search parameters (minimum and maximum limit)
     * @return The list of flowers in the price range that not in use
     */
    public static ArrayList<Flower> filterFlowersInPriceRange(){
        SortFilterFlowersDAO filtrationFlower = new SortFilterFlowersDAO();
        double min = filtrationFlower.minPrice();
        double max = filtrationFlower.maxPrice();

        printBanner("To filter by price, you must enter in which price range you are looking for flowers." +
                "\nStore flower price range: min price - " + min + " max price - " + max);

        System.out.println("Type the min price for your search in range [" + min + ", " + max + "] : ");
        double enteredMin = InputControl.enterDoubleInRange(min, max);

        printInfoEntering("Type the max for your search in range [" + min + ", " + max + "]" +
                " and bigger than " + enteredMin + ":");

        double enteredMax  = InputControl.enterDoubleInRangeAndBiggerThan(min, max, enteredMin);
        filteredFlowers = filtrationFlower.filterInPriceRange(enteredMin, enteredMax);
        filteredFlowers.removeAll(bouquetFlowers);
        return filteredFlowers;
    }

    /**
     * The method that searches for flowers in a length range that not in use
     * The method asks the user to enter the search parameters (minimum and maximum limit)
     * @return The list of flowers in the length range
     */
    public static ArrayList<Flower> filterFlowersInLengthRange(){
        SortFilterFlowersDAO filtrationFlower = new SortFilterFlowersDAO();
        double min = filtrationFlower.minLength();
        double max = filtrationFlower.maxLength();

        printBanner("To filter by length, you must enter in which price range you are looking for flowers." +
                "\nStore flower length range: min length - " + min + " max length - " + max);

        System.out.println("Type the min length for your search in range [" + min + ", " + max + "] : ");
        double enteredMin = InputControl.enterDoubleInRange(min, max);

        printInfoEntering("Type the max for your search in range [" + min + ", " + max + "]" +
                " and bigger than " + enteredMin + ":");

        double enteredMax  = InputControl.enterDoubleInRangeAndBiggerThan(min, max, enteredMin);
        filteredFlowers = filtrationFlower.filterInLengthRange(enteredMin, enteredMax);
        filteredFlowers.removeAll(bouquetFlowers);
        return filteredFlowers;
    }

    public static void printFilteredFlowers(){
        printList(filteredFlowers, "Flower search result:");
    }
}
