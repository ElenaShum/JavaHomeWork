package com.pb.blinov.hw10;

import java.util.Arrays;

public class NumBox<T extends Number> {
    private int filled = 0;
    private T[] numbers;

    @SuppressWarnings("unchecked")
    public NumBox(int size) {
        this.numbers = (T[]) new Number[size];
    }

    public T get(int index) {
        return numbers[index];
    }

    void add(T t) throws Exception {
        if(this.filled >= this.numbers.length){
            throw new Exception("Array already filled!");
        }
        this.numbers[this.filled] = t;
        this.filled++;
    }

    public int length(){
        return this.filled;
    }

    public double sum(){
        double sum = 0;
        for( int i = 0; i < filled; i++){
            sum += numbers[i].doubleValue();
        }
        return sum;
    }

    public double average(){
        return this.sum()/filled;
    }

    public T max(){
        T max = numbers[0];
        for( int i = 0; i < filled; i++){
            if(numbers[i].doubleValue() > max.doubleValue()) max = numbers[i];
        }
        return max;
    }

    @Override
    public String toString() {
        return "NumBox{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }
}
