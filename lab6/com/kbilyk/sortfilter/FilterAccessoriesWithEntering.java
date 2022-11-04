package com.kbilyk.sortfilter;

import com.kbilyk.item.Accessory;
import com.kbilyk.inputOutput.InputControl;

import java.util.ArrayList;

import static com.kbilyk.Bouquet.bouquetAccessories;
import static com.kbilyk.inputOutput.MakeBeautyOutput.*;
import static com.kbilyk.constant.AccessoryType.getAccessoryType;

public class FilterAccessoriesWithEntering {

    // Static arraylist of current filtering/sorting of accessories
    public static ArrayList<Accessory> filteredAccessories = new ArrayList<>();

    /**
     * The method that searches for accessories of a given type that not in use
     * This method calls for the user to enter the filter parameters
     * @return The list of accessories of a given type
     */
    public static ArrayList<Accessory> filterAccessoriesByType() {
        SortFilterAccessoriesDAO sortFilterAccessoriesDAO = new SortFilterAccessoriesDAO();
        filteredAccessories = sortFilterAccessoriesDAO.sortByType(getAccessoryType());
        filteredAccessories.removeAll(bouquetAccessories);
        return filteredAccessories;
    }

    /**
     * The method that returns all accessories that not in use
     * This method calls for the user to enter the filter parameters
     * @return The list of all accessories that not used
     */
    public static ArrayList<Accessory> filterAllAccessories() {
        SortFilterAccessoriesDAO sortFilterAccessoriesDAO = new SortFilterAccessoriesDAO();
        filteredAccessories = sortFilterAccessoriesDAO.getAll();
        filteredAccessories.removeAll(bouquetAccessories);
        return filteredAccessories;
    }

    /**
     * The method that searches for accessories in a price range
     * The method asks the user to enter the search parameters (minimum and maximum limit)
     * @return The list of accessories in the price range
     */
    public static ArrayList<Accessory> filterAccessInPriceRange() {

        SortFilterAccessoriesDAO filtrationAccessory = new SortFilterAccessoriesDAO();

        double min = filtrationAccessory.minPrice();
        double max = filtrationAccessory.maxPrice();

        printBanner("To filter by price, you must enter in which price range you are looking for accessories." +
                "\nStore accessory price range: min price - " + min + " max price - " + max);

        System.out.println("Type the min for your search in range [" + min + ", " + max + "] : ");
        double enteredMin = InputControl.enterDoubleInRange(min, max);

        printInfoEntering("Type the max for your search in range [" + min + ", " + max + "]" +
                " and bigger than " + enteredMin + ":");

        double enteredMax = InputControl.enterDoubleInRangeAndBiggerThan(min, max, enteredMin);
        filteredAccessories = filtrationAccessory.filterInPriceRange(enteredMin, enteredMax);
        filteredAccessories.removeAll(bouquetAccessories);
        return filteredAccessories;
    }

    public static void printFilteredAccessories() {
        printList(filteredAccessories, "Accessory search result:");
    }
}
