package com.kbilyk.item;

import com.kbilyk.inputOutput.InputControl;
import com.kbilyk.constant.AccessoryType;

import java.util.Objects;

import static com.kbilyk.inputOutput.MakeBeautyOutput.printInfoEntering;
import static com.kbilyk.constant.AccessoryType.printAccessoryType;

public class Accessory {
    private int id;         // the id of accessory in database
    private AccessoryType accessoryType;  // the type of accessory
    private String colour;
    private double price;
    private String info;

    private static final int maxSizeOfInformation = 250;

    private static final int maxSizeOfColour = 70;

    public Accessory() {}

    public static Accessory.AccessoryBuilder builder(){
        return new Accessory.AccessoryBuilder();
    }

    public int getId() {
        return id;
    }

    public AccessoryType getAccessoryType() {
        return accessoryType;
    }

    public String getColour() {
        return colour;
    }

    public double getPrice() {
        return price;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "Accessory{" +
                "id=" + id +
                ", accessoryType=" + accessoryType +
                ", colour='" + colour + '\'' +
                ", price=" + price +
                ", info='" + info + '\'' +
                '}' + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accessory accessory = (Accessory) o;
        return id == accessory.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static class AccessoryBuilder{
        private final Accessory accessory;

        AccessoryBuilder(){
            accessory = new Accessory();
        }
        public AccessoryBuilder setId(int id) {
            accessory.id = id;
            return this;
        }

        public AccessoryBuilder setAccessoryType(AccessoryType accessoryType) {
            accessory.accessoryType =  accessoryType;
            return this;
        }

        public AccessoryBuilder setColour(String colour) {
            accessory.colour = colour;
            return this;
        }

        public AccessoryBuilder setPrice(double price) {
            accessory.price = price;
            return this;
        }

        public AccessoryBuilder setInfo(String info) {
            accessory.info = info;
            return this;
        }

        public AccessoryBuilder setAccessoryType() {
            printInfoEntering("Choose the type of accessory");
            printAccessoryType();
            accessory.accessoryType = AccessoryType.getAccessoryType();
            return this;
        }

        public AccessoryBuilder setColour() {
            printInfoEntering("Type the colour of accessory (max symbols " + maxSizeOfColour + "): ");
            accessory.colour = InputControl.enterStringLessThen(maxSizeOfColour);
            return this;
        }

        public AccessoryBuilder setPrice() {
            printInfoEntering("Type the price of accessory: ");
            accessory.price = InputControl.enterCorrectDouble();
            return this;
        }

        public AccessoryBuilder setInfo() {
            printInfoEntering("Type the info about accessory (max symbols " + maxSizeOfInformation + "): ");
            accessory.info = InputControl.enterStringLessThen(maxSizeOfInformation);
            return this;
        }

        public Accessory built(){
        return accessory;
        }
    }
}
