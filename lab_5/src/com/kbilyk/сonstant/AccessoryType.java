package com.kbilyk.сonstant;

import com.kbilyk.Error;

public enum AccessoryType {

    GELBALL(1, "Gel ball"),
    POSTCARD(2, "Postcard"),

    HEART(3, "Heart"),

    PAPER (4, "Gift paper" ),

    RIBBON (5, "Ribbon"),
    BEAR (6, "Bear");

    private final int type;

    private final String name;

    AccessoryType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public static void printAccessoryType(){

        System.out.println("\n-----------------------------");
        System.out.println("Types of flowers");
        System.out.println("-----------------------------");
        for(AccessoryType type : AccessoryType.values()){
            System.out.println(type.type + "." + type.name);
        }
        System.out.println("-----------------------------");

    }

    public static AccessoryType getAccessoryType(){

        System.out.println("Choose option:");
        int numType = Error.enterCorrectInt();

        for(AccessoryType type : AccessoryType.values()){
            if(type.type == numType){
                return type;
            }
        }

        System.out.println("You type a wrong num! Try again");
        return getAccessoryType();

    }
}
