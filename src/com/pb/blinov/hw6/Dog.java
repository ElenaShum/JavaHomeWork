package com.pb.blinov.hw6;

import java.util.Objects;

public class Dog extends Animal{
    private int scentDistance;

    public Dog(String name, String food, String location, int scentDistance) {
        super(name,food,location);
        this.scentDistance = scentDistance;
    }

    public int getScentDistance() {
        return scentDistance;
    }

    @Override
    public void makeNoise() {
        System.out.println(getName() + " лает ГАВ-ГАВ!");
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,food,location,scentDistance);
    }

    @Override
    public String toString() {
        return "Пёс" +
                " по кличке '" + name + '\'' +
                ", ест '" + food + '\'' +
                ", живет в '" + location + '\'' +
                ", чует нарушителя за " + scentDistance +
                " метров";
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
        Dog dog = (Dog) o;
// field comparison
        return Objects.equals(this.name, dog.name)
                && Objects.equals(this.food, dog.food)
                && Objects.equals(this.scentDistance, dog.scentDistance);
    }
}
