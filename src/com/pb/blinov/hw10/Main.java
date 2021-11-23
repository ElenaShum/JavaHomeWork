package com.pb.blinov.hw10;

public class Main {
    public static void main(String[] args) {
        int size = 53;
       NumBox<Float> floatNumBox = new NumBox<>(size);
        for (int i = 0; i < size ; i++){
            try {
                floatNumBox.add((float) Math.random()*100);
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        System.out.println("Демонстрация NumBox<Float>");
        show(floatNumBox);
        System.out.println("--------------------");

        NumBox<Integer> intNumBox = new NumBox<>(size);
        for (int i = 0; i < size ; i++){
            try {
                intNumBox.add((int) (Math.random()*100));
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        System.out.println("Демонстрация NumBox<Integer>");
        show(intNumBox);
    }

    public static void show(NumBox<?> box){
        System.out.println(box);
        System.out.println("Сумма: "+box.sum());
        System.out.println("Размер "+box.length());
        System.out.println("Среднее значение " +box.average());
        int index = (int) (Math.random()*box.length());
        System.out.println("Значение елемента "+(index+1)+" равно "+box.get(index));
        System.out.println("Максимум "+box.max());
    }
}
