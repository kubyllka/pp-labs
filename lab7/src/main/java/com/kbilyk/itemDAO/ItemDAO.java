package com.kbilyk.itemDAO;

public interface ItemDAO<T>{

    /**
     * Method searches for an object with the specified id in the source
     * @param id The id of object
     * @return The object with the specified id
     */
    T getById(int id);

    /**
     * Method that deletes the specified object in the source
     * @param t The object to delete
     * @return The number of successful removal operations
     */

    int delete(T t);

    /**
     * Method that inserts the specified object to the source
     * @param t The object to insert
     * @return The number of successful inserting operations
     */
    int insert(T t);

    /**
     * Method that inserts the new object to the database
     * Method asks user to create a new object
     */
    void insertWithEntering();

    /**
     * Method deletes one object that is in filtered list from database
     * Method asks the user to choose the object to delete
     */
    void deleteFromFiltered();

    /**
     * Method deletes all objects that is in bouquet from database
     */
    void deleteAllFromBouquet();



}
