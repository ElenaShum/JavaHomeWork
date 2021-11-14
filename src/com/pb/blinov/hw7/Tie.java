package com.pb.blinov.hw7;

public class Tie extends Clothes implements ManClothes{
    public Tie(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Галстук " +
                "размер : " + size +
                ", описание : " + size.getDescription() +
                ", европейский размер : " + size.getEuroSize() +
                ", цена : " + price +
                ", цвет : '" + color + '\'';
    }
}
