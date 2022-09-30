package com.kbilyk.houses;

import com.kbilyk.house.House;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The list of entered houses
 * and methods to sort
 */
public class Houses {

    private final ArrayList<House> houses  = new ArrayList<>();

    public Houses(){
        enteringHouses();
    }


    /**
     * Entering an arbitrary number of houses
     */
    private void enteringHouses() {
        System.out.println("-------------------------------------");
        System.out.println("Enter the info about house (stop - type enter or letter in id)!");
        while (true) {
            House house = enterInfo();
            if (house == null){
                return;
            }
            houses.add(house);
        }
    }

    /**
     * Entering all the information about the house
     * @return The object house with entered info
     */

    private House enterInfo(){
        House house = new House();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the id of house: ");
        String line = input.nextLine();
        // check if user type enter or letter in id
        // if it`s true - return null, else - continue entering
        try {
            house.setId(Integer.parseInt(line));
        } catch (NumberFormatException e) {
            return null;
        }
        // entering all others info
        System.out.println("Enter the number of house: ");
        house.setnHouse(input.nextInt());
        System.out.println("Enter the area of house: ");
        house.setArea(input.nextDouble());
        System.out.println("Enter the floor on which house is located: ");
        house.setFloor(input.nextInt());
        System.out.println("Enter the number of rooms: ");
        house.setRooms(input.nextInt());
        System.out.println("Enter the name of street on which house is located: ");
        house.setStreet(input.next());

        return house;
    }


    /**
     * Finding houses with a given number of rooms
     *
     * @return The list of houses with given number of rooms
     */
    public ArrayList<House> searchRooms()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter the number of rooms for search: ");
        int rooms = input.nextInt();
        ArrayList<House> hosesWithNrooms = new ArrayList<>();
        for (House house : houses) {
            if (house.getRooms() == rooms) {
                hosesWithNrooms.add(house);
            }
        }
        return hosesWithNrooms;
    }

    /**
     * Finding houses with given number of rooms and which situated in interval of floors [min, max]
     * @return The list of houses with given number of rooms and which situated in interval of floors [min, max]
     */
    public ArrayList<House> searchRoomsAndFloor()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter the min floor of houses for search: ");
        int min = input.nextInt();
        System.out.println("Enter the max floor of houses for search: ");
        int max = input.nextInt();
        // search for houses with this number of rooms
        ArrayList<House> hosesWithNrooms = searchRooms();

        // check whether these sorted houses are found on the floor interval
        ArrayList<House> hosesWithFloorInter = new ArrayList<>();
        for (House house : hosesWithNrooms) {
            if (house.getFloor() >= min && house.getFloor() <= max){
                hosesWithFloorInter.add(house);
            }
        }
        return hosesWithFloorInter;
    }

    /**
     * Finding houses where each area is bigger or equal for given area
     * @return The list of houses where each area is bigger or equal for entered area
     */
    public ArrayList<House> searchArea() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter the area for search: ");
        double area = input.nextDouble();
        ArrayList<House> hosesWithArea = new ArrayList<>();
        for (House house : houses) {
            if (house.getArea() >= area) {
                hosesWithArea.add(house);
            }
        }
        return hosesWithArea;
    }

    /**
     * Getter which return the list of entered houses
     * @return The list of entered houses
     */
    public ArrayList<House> getHouses(){ return houses;}
}
