package com.pb.blinov.hw7;

public class Atelier {
    public static void main(String[] args) {
        Clothes[] clothes = {
                new Pants(Size.S,50.25, "Черные"),
                new Skirt(Size.XS, 100.25, "Белая"),
                new Tshirt(Size.XXS, 10.25, "Красная"),
                new Tshirt(Size.L, 210.25, "Красная"),
                new Tie(Size.M, 200, "Малиновый")
        };
        dressMan(clothes);
        dressWomen(clothes);
    }

    public static void dressMan(Clothes[] clothes){
        System.out.println("\nОдеваем мужчину");
        for (Clothes cloth : clothes){
            if (cloth instanceof ManClothes){
                ((ManClothes) cloth).dressMan();
            }
        }
    }

    public static void dressWomen(Clothes[] clothes){
        System.out.println("\nОдеваем женщину");
        for (Clothes cloth : clothes){
            if (cloth instanceof WomenClothes){
                ((WomenClothes) cloth).dressWomen();
            }
        }
    }
}
