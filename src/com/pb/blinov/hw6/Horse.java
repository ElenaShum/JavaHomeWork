package com.pb.blinov.hw6;

import java.util.Objects;

public class Horse extends Animal{
    private int gallopSpeed;

    public Horse(String name, String food, String location,int gallopSpeed) {
        super(name,food,location);
        this.gallopSpeed = gallopSpeed;
    }

    @Override
    public void makeNoise() {
        System.out.println(getName()+" Иго-го!");
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,food,location,gallopSpeed);
    }

    @Override
    public String toString() {
        return "Лошадь по кличке '" +
                name + '\'' +
                ", ест '" + food + '\'' +
                ", живет в '" + location + '\'' +
                ", бежит со скоростью " + gallopSpeed +
                " км/ч";
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
        Horse horse = (Horse) o;
// field comparison
        return Objects.equals(this.name, horse.name)
                && Objects.equals(this.food, horse.food)
                && Objects.equals(this.gallopSpeed, horse.gallopSpeed);
    }
}
