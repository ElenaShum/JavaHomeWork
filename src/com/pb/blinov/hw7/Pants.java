package com.pb.blinov.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes{
    public Pants(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println(this.toString());
    }

    @Override
    public void dressWomen() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Штаны " +
                "размер : " + size +
                ", описание : " + size.getDescription() +
                ", европейский размер : " + size.getEuroSize() +
                ", цена : " + price +
                ", цвет : '" + color + '\'';
    }
}
