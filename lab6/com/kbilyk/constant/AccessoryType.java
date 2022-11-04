package com.kbilyk.constant;

import com.kbilyk.inputOutput.InputControl;

import static com.kbilyk.inputOutput.MakeBeautyOutput.*;

public enum AccessoryType {

    GELBALL(1, "Gel ball"),

    POSTCARD(2, "Postcard"),

    HEART(3, "Heart"),

    PAPER (4, "Gift paper" ),

    RIBBON (5, "Ribbon"),

    BEAR (6, "Bear");

    private final int numType;

    private final String name;

    AccessoryType(int numType, String name) {
        this.numType = numType;
        this.name = name;
    }

    public static void printAccessoryType(){
        printBanner("Types of accessories");
        for(AccessoryType type : AccessoryType.values()){
            System.out.println(type.numType + "." + type.name);
        }
    }

    public static AccessoryType getAccessoryType(int indx){
        for(AccessoryType type : AccessoryType.values()){
            if(type.numType == indx){
                return type;
            }
        }
        printError("You type a wrong num! Try again");
        return null;
    }

    public static AccessoryType getAccessoryType(){
        printAccessoryType();
        printInfoEntering("Choose type of accessory:");
        int numType = InputControl.enterCorrectInt();

        for(AccessoryType type : AccessoryType.values()){
            if(type.numType == numType){
                return type;
            }
        }

        printError("You type a wrong num! Try again");
        return getAccessoryType();

    }

    public int getNumType() {
        return numType;
    }

}
