package com.pb.blinov.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first;
        System.out.println("Введите целое число: ");
        first = scan.nextInt();
        if (first >= 0 && first < 15) {
            System.out.println("Ваше число в диапазоне от 0 до 14");
        } else if (first >= 15 && first < 36){
            System.out.println("Ваше число в диапазоне от 15 до 35");
        } else if (first >= 36 && first < 51){
            System.out.println("Ваше число в диапазоне от 36 до 50");
        } else if (first >= 51 && first < 100){
            System.out.println("Ваше число в диапазоне от 51 до 100");
        } else {
            System.out.println("Ваше число не в нашем диапазоне");
        }
    }
}
