package com.kbilyk.сonstant;

import com.kbilyk.Error;

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

    private final int type;
    private final String name;

    FlowerType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public static void printFlowerType(){
        System.out.println("\n-----------------------------");
        System.out.println("Types of flowers");
        System.out.println("-----------------------------");
        for(FlowerType type : FlowerType.values()){
            System.out.println(type.type + "." + type.name);
        }
        System.out.println("-----------------------------");
    }

    public static FlowerType getFlowerType(){

        System.out.println("Choose option:");
        int numType = Error.enterCorrectInt();

        for(FlowerType type : FlowerType.values()){
            if(type.type == numType){
                return type;
            }
        }

        System.out.println("You type a wrong num! Try again");
        return getFlowerType();

    }
}
