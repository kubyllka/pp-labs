package com.kbilyk.inputOutput;

import java.util.ArrayList;

public class MakeBeautyOutput {

    public static String line = "---------------------------------------------------";
    public static String newLine = "\n---------------------------------------------------";

    /**
     * Print the info about entering
     * @param info The info about entering
     */
    public static void printInfoEntering(String info){
        System.out.println(line);
        System.out.println(info);
    }

    /**
     * Print the banner info
     * @param info The info about banner
     */
    public static void printBanner(String info){
        System.out.println(newLine);
        System.out.println(info);
        System.out.println(line);
    }

    /**
     * Method print an error
     * @param error The info about error
     */
    public static void printError(String error){
        System.out.println(line);
        System.out.println("\uD83D\uDD2A " + error);
        System.out.println(line);
    }

    /**
     * Method displays array list with indexes and info about this list
     * @param arrayList The array list to display
     * @param info The info about array list
     * @param <T> The type of array list
     */
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
