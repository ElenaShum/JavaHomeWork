package com.pb.blinov.hw6;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class VetClinic {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException {
        Cat cat = new Cat("Рыжик","Мышей", "Дом", 10);
        Dog dog = new Dog("Тузик","Кости", "Будка", 30);
        Horse horse = new Horse("Ветер","Траву", "Стойло", 50);
        Animal[] animals = {(Animal) cat, (Animal) dog, (Animal) horse};
        for (Animal animal : animals) {
            System.out.println(animal);
        }
        for (Animal animal : animals) {
            animal.makeNoise();
        }
        Class clazz = Class.forName("com.pb.blinov.hw6.Veterinarian");
        Constructor constr = clazz.getConstructor();
        Object obj = constr.newInstance();
        if (obj instanceof Veterinarian) {
            for (Animal animal : animals) {
                ((Veterinarian) obj).treatAnimal(animal);
            }
        }
    }
}
