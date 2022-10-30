package com.kbilyk;

import com.kbilyk.сonstant.FlowerType;

import java.util.Date;

public class Flower {

    private int id;
    private double price;
    private double length;
    private FlowerType flowerType;
    private String colour;
    private Date date = new Date();

    public Flower(int id, int price, double length, String colour, FlowerType flowerType) {
        this.id = id;
        this.price = price;
        this.length = length;
        this.colour = colour;
        this.flowerType = flowerType;

    }

    @Override
    public String toString() {
        return "Flower{" +
                "id=" + id +
                ", price=" + price +
                ", length=" + length +
                ", colour='" + colour + '\'' +
                ", date=" + date +
                '}' + '\n';
    }
}
