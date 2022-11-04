package com.kbilyk.item;

import com.kbilyk.inputOutput.InputControl;
import com.kbilyk.constant.FlowerType;

import java.util.Date;
import java.util.Objects;

import static com.kbilyk.inputOutput.MakeBeautyOutput.printInfoEntering;

public class Flower {
    private int id;
    private FlowerType flowerType;
    private String colour;
    private double length;
    private double price;
    private Date date = null;

    private static final int maxSizeOfColour = 70;

    public Flower() {}

    public int getId() {
        return id;
    }

    public FlowerType getFlowerType() {
        return flowerType;
    }

    public String getColour() {
        return colour;
    }

    public double getLength() {
        return length;
    }

    public double getPrice() {
        return price;
    }

    public java.sql.Date getDate() {
        return (java.sql.Date) date;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "id=" + id +
                ", flowerType=" + flowerType +
                ", colour='" + colour + '\'' +
                ", length=" + length +
                ", price=" + price +
                ", date=" + date +
                '}' + '\n';
    }

    public static FlowerBuilder builder(){
        return new FlowerBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return id == flower.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public static class FlowerBuilder{

        private Flower flower;

        FlowerBuilder() {
            this.flower = new Flower();
        }

        public FlowerBuilder setId(int id) {
            flower.id = id;
            return this;
        }

        public FlowerBuilder setFlowerType(FlowerType flowerType) {
            flower.flowerType = flowerType;
            return this;
        }

        public FlowerBuilder setColour(String colour) {
            flower.colour = colour;
            return this;
        }

        public FlowerBuilder setLength(double length) {
            flower.length = length;
            return this;
        }

        public FlowerBuilder setPrice(double price) {
            flower.price = price;
            return this;
        }

        public FlowerBuilder setDate(Date date) {
            flower.date = date;
            return this;
        }


        public FlowerBuilder setFlowerType() {
            printInfoEntering("Choose the type of flower");
            flower.flowerType = FlowerType.getFlowerType();
            return this;
        }

        public FlowerBuilder setColour() {
            printInfoEntering("Type the colour of accessory (max symbols " + maxSizeOfColour + "):");
            flower.colour = InputControl.enterStringLessThen(maxSizeOfColour);
            return this;
        }

        public FlowerBuilder setLength() {
            printInfoEntering("Type the length of flower:");
            flower.length = InputControl.enterCorrectDouble();
            return this;
        }

        public FlowerBuilder setPrice() {
            printInfoEntering("Type the price of flower:");
            flower.price = InputControl.enterCorrectDouble();
            return this;
        }

        public Flower built(){
            return flower;
        }

    }
}
