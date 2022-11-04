package com.kbilyk.inputOutput;

import java.util.ArrayList;

public class MakeBeautyOutput {

    public static String line = "---------------------------------------------------";
    public static String newLine = "\n---------------------------------------------------";


    public static void printInfoEntering(String info){
        System.out.println(line);
        System.out.println(info);
    }

    public static void printBanner(String info){
        System.out.println(newLine);
        System.out.println(info);
        System.out.println(line);
    }

    public static void printError(String error){
        System.out.println(line);
        System.out.println("\uD83D\uDD2A " + error);
        System.out.println(line);
    }

    public static <T> void printList(ArrayList<T> arrayList, String info){
        printBanner(info);
        if(arrayList.isEmpty()){
            System.out.println("\nNothing was found =(");
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i) != null){
                System.out.println(i + ". " + arrayList.get(i));
            }
        }
    }
}
