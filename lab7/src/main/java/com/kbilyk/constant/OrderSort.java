package com.kbilyk.constant;

import com.kbilyk.inputOutput.InputControl;

import static com.kbilyk.inputOutput.MakeBeautyOutput.*;

public enum OrderSort {

    DESC (1, "In descending order"),

    ASC (2, "In ascending order" );

    private final int numType;    // the number of that type
    private final String name;    // the name of accessory type

    OrderSort(int type, String name) {
        this.numType = type;
        this.name = name;
    }

    /**
     * Displays all order types
     */
    public static void printOrderSortType(){
        printBanner("Types of order");
        for(OrderSort type : OrderSort.values()){
            System.out.println(type.numType + ". " + type.name);
        }
    }

    /**
     * Get flower type by number of accessory type
     * @param numType The number of flower type
     * @return The flower type
     */
    public static OrderSort getOrderSortType(int numType){
        for(OrderSort type : OrderSort.values()){
            if(type.numType == numType){
                return type;
            }
        }
        printError("You type a wrong num! Try again");
        return null;
    }

    /**
     * Get order type by number of order type
     * Method asks the user to select a number of order type
     * @return The order type
     */
    public static OrderSort getOrderSortType(){
        printOrderSortType();
        printInfoEntering("Choose the order type:");
        int numType = InputControl.enterCorrectInt();

        for(OrderSort type : OrderSort.values()){
            if(type.numType == numType){
                return type;
            }
        }

        printError("You type a wrong num! Try again");
        return getOrderSortType();
    }
}
