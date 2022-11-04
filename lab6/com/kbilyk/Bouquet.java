package com.kbilyk;
import com.kbilyk.item.Accessory;
import com.kbilyk.item.Flower;
import com.kbilyk.itemDAO.AccessoryDAO;
import com.kbilyk.itemDAO.FlowerDAO;

import java.util.ArrayList;
import java.util.Objects;

import static com.kbilyk.inputOutput.InputControl.*;
import static com.kbilyk.inputOutput.MakeBeautyOutput.*;
import static com.kbilyk.sortfilter.FilterAccessoriesWithEntering.filteredAccessories;
import static com.kbilyk.sortfilter.FilterFlowersWithEntering.filteredFlowers;


public class Bouquet {

    // The flowers in bouquet
    public static ArrayList<Flower> bouquetFlowers = new ArrayList<>();
    // The accessories in bouquet
    public static ArrayList<Accessory> bouquetAccessories = new ArrayList<>();

    /**
     * A method that displays all the information about the bouquet
     * (flowers in the bouquet, accessories in the bouquet,
     * the average length of the stems, the price of the bouquet)
     */
    public static void printBouquetInfo(){
        printBouquetFlowers();
        printBouquetAccessories();
        printBanner("The price of bouquet: " + priceOfBouquet());
        printBanner("The average length flower in bouquet: " + averageLengthOfFlowers());
    }

    /**
     * A method that prints flowers in a bouquet
     */
    public static void printBouquetFlowers(){
        printList(bouquetFlowers, "Flowers in bouquet");
    }

    /**
     * A method that prints accessories in a bouquet
     */
    public static void printBouquetAccessories(){
        printList(bouquetAccessories, "Accessories in bouquet:");
    }

    /**
     * Method that calculates the price of a bouquet
     * @return The price of bouquet
     */
    public static double priceOfBouquet(){
        double price = 0.0;
        for(Flower flower : bouquetFlowers) price += flower.getPrice();
        for(Accessory accessory : bouquetAccessories) price += accessory.getPrice();
        return price;
    }

    /**
     * Method that calculates the average length of stems of a bouquet
     * @return The average length of bouquet
     */
    public static double averageLengthOfFlowers(){
        double length = 0.0;
        for(Flower flower : bouquetFlowers) length += flower.getPrice();
        return length / bouquetFlowers.size();
    }

    /**
     * A method that adds an accessory to the bouquet.
     * The method asks the user to enter the index of the accessory from the filtering list.
     * if there is such an index - add the accessory to the bouquet
     * and null the value of this accessory in the filtering list
     */

    public static void addAccessoryFromFilteredList(){
        Accessory accessory = enterCorrectIndexAccessory(filteredAccessories);
        if(accessory != null){
            bouquetAccessories.add(accessory);
            filteredAccessories.set(filteredAccessories.indexOf(accessory), null);
        }
        if(filteredAccessories.stream().allMatch(Objects::isNull)){
            filteredAccessories.clear();
        }
    }

    /**
     * A method that adds a flower to the bouquet.
     * The method asks the user to enter the index of the flower from the filtering list.
     * if there is such an index - add the flower to the bouquet
     * and null the value of this flower in the filtering list
     */
    public static void addFlowerFromFilteredList(){
        Flower flower = enterCorrectIndexFlowers(filteredFlowers);
        if(flower != null){
            Bouquet.bouquetFlowers.add(flower);
            filteredFlowers.set(filteredFlowers.indexOf(flower), null);
        }
        if(filteredFlowers.stream().allMatch(Objects::isNull)){
            filteredFlowers.clear();
        }
    }

    /**
     * A method that deletes a flower from the bouquet.
     * The method asks the user to enter the index of the flower from the bouquet flowers list.
     * if there is such an index - null the value of this flower in the bouquet flowers list
     */

    public static void deleteFlowerFromBouq(){
        Flower flower = enterCorrectIndexFlowers(bouquetFlowers);
        if(flower != null){
            bouquetFlowers.set(bouquetFlowers.indexOf(flower), null);
        }

        if(bouquetFlowers.stream().allMatch(Objects::isNull)){
            bouquetFlowers.clear();
        }
    }

    /**
     * A method that deletes an accessory from the bouquet.
     * The method asks the user to enter the index of the flower from the bouquet accessories list.
     * if there is such an index - null the value of this flower in the bouquet accessories list
     */
    public static void deleteAccessoryFromBouq(){

        Accessory accessory = enterCorrectIndexAccessory(bouquetAccessories);
        if(accessory != null){
            bouquetAccessories.set(bouquetAccessories.indexOf(accessory), null);
        }

        if(bouquetAccessories.stream().allMatch(Objects::isNull)){
            bouquetAccessories.clear();
        }
    }

    /**
     * Method buy a bouquet
     * All flowers and accessories that are in the bouquet are removed from the database
     */
    public static void buyBouquetDAO(){
        printBouquetInfo();
        AccessoryDAO aDao = new AccessoryDAO();
        aDao.deleteAllFromBouquet();
        FlowerDAO fDao = new FlowerDAO();
        fDao.deleteAllFromBouquet();
        printBanner("This bouquet was successfully bought!");
    }

    /**
     * A method that updates the bouquet when the user exits the bouquet creation menu
     * (removes all flowers and accessories from it)
     */
    public static void refreshBouquet(){
        bouquetFlowers.clear();
        bouquetAccessories.clear();
    }
}
