package com.kbilyk.constant;

import com.kbilyk.inputOutput.InputControl;

import static com.kbilyk.inputOutput.MakeBeautyOutput.*;

public enum OrderSort {

    DESC (1, "In descending order"),

    ASC (2, "In ascending order" );

    private final int numType;
    private final String name;

    OrderSort(int type, String name) {
        this.numType = type;
        this.name = name;
    }

    public static void printOrderSortType(){
        printBanner("Types of order");
        for(OrderSort type : OrderSort.values()){
            System.out.println(type.numType + ". " + type.name);
        }
    }

    public static OrderSort getOrderSortType(int indx){
        for(OrderSort type : OrderSort.values()){
            if(type.numType == indx){
                return type;
            }
        }
        printError("You type a wrong num! Try again");
        return null;
    }

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
