package com.kbilyk.house;

/**
 * Class House.
 * House: id, Apartment number, Area, Floor, Number of rooms, Street.
 */
public class House {
    private int id;         //The id of the house
    private int nHouse;     //The number of house
    private double area;    //The area of that house
    private int floor;      //The floor in which situated
    private int rooms;      //The number of rooms
    private String street;  //The name of the street on which the house is located

    /**
     * Default constructor
     */
    public House(){}

    /**
     * Constructor
     * @param id The id of the house
     * @param nHouse The number of house
     * @param area The area of that house
     * @param floor The floor on which situated the house
     * @param rooms The number of rooms
     * @param street The name of the street on which the house is located
     */
    House(int id, int nHouse, double area, int floor,
          int rooms, String street) {
        this.id = id;
        this.nHouse = nHouse;
        this.area = area;
        this.floor = floor;
        this.rooms = rooms;
        this.street = street;
    }

    /**
     * Getter which return the id
     * @return id of the house
     */
    public int getId() {
        return id;
    }

    /**
     * Getter which return the number of house
     * @return The number of house
     */
    public int getnHouse() {
        return nHouse;
    }

    /**
     * Getter which return the area
     * @return The area of house
     */
    public double getArea() {
        return area;
    }

    /**
     * Getter which return
     * @return The floor on which house is located
     */
    public int getFloor() {
        return floor;
    }

    /**
     * Getter which return the number of rooms
     * @return The number of rooms in the house
     */
    public int getRooms() {
        return rooms;
    }

    /**
     * Getter which return the Street
     * @return The name of the street on which the house is located
     */
    public String getStreet() {
        return street;
    }

    /**
     * Displaying information about the house in the form of a string
     * @return Info about house
     */
    @Override
    public String toString() {
        return String.format("id = %-8d nHouse = %-4d area = %-8.3f floor = %-4d rooms = %-4d street = %-20s",
                id, nHouse, area, floor, rooms, street);
    }

    /**
     * Setter that change the id of the house
     * @param id The id of house
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter that change the number of house
     * @param nHouse The number of that house
     */
    public void setnHouse(int nHouse) {
        this.nHouse = nHouse;
    }

    /**
     * Setter which change the area of the house
     * @param area The area of house
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * Setter that change the floor
     * @param floor The floor on which house is situated
     */
    public void setFloor(int floor) {
        this.floor = floor;
    }

    /**
     * Setter that changes the number of rooms
     * @param rooms The number of rooms at the house
     */
    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    /**
     * Setter that changes the name of the street
     * @param street The name of the street on which the house is located
     */
    public void setStreet(String street) {
        this.street = street;
    }
}
