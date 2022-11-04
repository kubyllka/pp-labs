package com.kbilyk.constant;

import com.kbilyk.inputOutput.InputControl;

import static com.kbilyk.inputOutput.MakeBeautyOutput.*;

public enum FlowerType {

    ROSE(1, "Rose"),

    LAVANDULA(2, "Lavandula"),

    LILY(3, "Lily"),

    LUPINE(4, "Lupine"),

    GYPSOPHILA(5, "Gypsophila"),

    CHAMOMILE(6, "Chamomile"),

    CHRYSANTHEMUM(7, "Chrysanthemum"),

    TULIP(8, "Tulip"),

    DAFFODIL(9, "Daffodil");

    private final int numType;
    private final String name;

    FlowerType(int type, String name) {
        this.numType = type;
        this.name = name;
    }

    public static void printFlowerType(){
        printBanner("Types of flowers");
        for(FlowerType type : FlowerType.values()){
            System.out.println(type.numType + "." + type.name);
        }
    }

    public static FlowerType getFlowerType(int indx){
        for(FlowerType type : FlowerType.values()){
            if(type.numType == indx){
                return type;
            }
        }
        printError("You type a wrong num! Try again");
        return null;
    }

    public static FlowerType getFlowerType(){
        printFlowerType();
        printInfoEntering("Choose a flower type:");
        int numType = InputControl.enterCorrectInt();

        for(FlowerType type : FlowerType.values()){
            if(type.numType == numType){
                return type;
            }
        }

        printError("You type a wrong num! Try again");
        return getFlowerType();
    }

    public int getNumType() {
        return numType;
    }
}
