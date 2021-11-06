package com.pb.blinov.hw6;

public class Animal {

    String name;
    String food;
    String location;

    public String getName() {
        return name;
    }

    public String getFood() {
        return food;
    }

    public String getLocation() {
        return location;
    }

    public Animal(String name, String food, String location) {
        this.name = name;
        this.food = food;
        this.location = location;
    }

    public void makeNoise() {
        System.out.println("What Does the Fox Say?");
    }

    public void eat() {
        System.out.println(getName()+" ест - "+getFood());
    }

    public void sleep() {
        System.out.println(getName()+" спит.");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", food='" + food + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
