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

    private final int numType;      // the number of that type

    private final String name;      // the name of accessory type

    AccessoryType(int numType, String name) {
        this.numType = numType;
        this.name = name;
    }

    /**
     * Displays all accessories types
     */
    public static void printAccessoryType(){
        printBanner("Types of accessories");
        for(AccessoryType type : AccessoryType.values()){
            System.out.println(type.numType + "." + type.name);
        }
    }

    /**
     * Get accessory type by number of accessory type
     * @param numType The number of accessory type
     * @return The accessory type
     */
    public static AccessoryType getAccessoryType(int numType){
        for(AccessoryType type : AccessoryType.values()){
            if(type.numType == numType){
                return type;
            }
        }
        printError("You type a wrong num! Try again");
        return null;
    }

    /**
     * Get accessory type by number of accessory type
     * Method asks the user to select a number of accessory type
     * @return The accessory type
     */
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

    /**
     * Get the number of accessory type
     * @return The number of accessory type
     */
    public int getNumType() {
        return numType;
    }

}
