package com.pb.blinov.hw7;

public class Skirt  extends Clothes implements WomenClothes{
    public Skirt(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressWomen() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Юбка ")
                .append("размер : ").append(size)
                .append(", описание : ").append(size.getDescription())
                .append(", европейский размер : ").append(size.getEuroSize())
                .append(", цена : ").append(price)
                .append(", цвет : '")
                .append(color).append('\'').toString();
    }
}
