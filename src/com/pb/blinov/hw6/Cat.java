package com.pb.blinov.hw6;

import java.util.Objects;

public class Cat extends Animal{

    private int purrVolume;

    public int getPurrVolume() {
        return purrVolume;
    }

    public Cat(String name, String food, String location, int purrVolume){
        super(name,food,location);
        this.purrVolume = purrVolume;
    }

    @Override
    public void makeNoise(){
        System.out.println("Кот мурчит с громкостью "+getPurrVolume()+" децибел.");
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,food,location,purrVolume);
    }

    @Override
    public String toString() {
        return "Кот по имени '" +
                name + '\'' +
                ", ест '" + food + '\'' +
                ", живет в '" + location + '\'' +
                ", мурчит с громкостью " + purrVolume +
                " децибел";
    }

    @Override
    public boolean equals(Object o) {
// self check
        if (this == o)
            return true;
// null check
        if (o == null)
            return false;
// type check and cast
        if (this.getClass() != o.getClass())
            return false;
        Cat cat = (Cat) o;
// field comparison
        return Objects.equals(this.name, cat.name)
                && Objects.equals(this.food, cat.food)
                && Objects.equals(this.purrVolume, cat.purrVolume);
    }


}
