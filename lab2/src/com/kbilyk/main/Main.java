package com.kbilyk.main;
import com.kbilyk.house.House;
import com.kbilyk.houses.Houses;
import java.util.ArrayList;

/**
 *  Makes an array of objects houses.
 *  Output:
 *  a) a list of apartments that have a given number of rooms;
 *  b) a list of apartments that have a given number of rooms and are located on a floor
 *  that is in a given interval;
 *  c) a list of apartments that have an area exceeding the specified area.
 *
 */
public class Main {
    public static void main(String[] args) {

        // entering houses
        Houses houses = new Houses();
        resOutput(houses.getHouses());

        // search for number of rooms
        ArrayList<House> hosesWithNrooms = houses.searchRooms();

        // output the result of search
        resOutput(hosesWithNrooms);

        // search for number of rooms and the floor interval [min, max]
        ArrayList<House> hWithNroomsAndFloorInter = houses.searchRoomsAndFloor();

        // output the result of search
        resOutput(hWithNroomsAndFloorInter);

        // search by area (areas equal to or greater than a certain value)
        ArrayList<House> housesWithArea = houses.searchArea();

        // output the result of search
        resOutput(housesWithArea);
    }

    /**
     * Displaying the list of houses on the screen
     * @param houses The list of houses to be displayed
     */
    private static void resOutput(ArrayList<House> houses){
        System.out.println("The result of search: ");
        if (houses.isEmpty()){
            System.out.println("Nothing was found.");
        } else {
            for(House house : houses){
                System.out.println(house);
            }
        }
    }

}
