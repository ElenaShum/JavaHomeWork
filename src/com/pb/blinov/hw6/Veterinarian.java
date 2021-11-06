package com.pb.blinov.hw6;

public class Veterinarian {
    public Veterinarian() {
    }

    public void treatAnimal(Animal animal){
        System.out.println(animal.getName()+" ест "+animal.getFood()+" живет: "+animal.getLocation());
    }
}
