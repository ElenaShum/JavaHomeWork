package com.pb.blinov.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first;
        int second;
        String symbol;
        System.out.println("Введите первое число: ");
        first = scan.nextInt();
        System.out.println("Введите второе число: ");
        second = scan.nextInt();
        System.out.println("Введите знак операции +-*/ : ");
        symbol = scan.next();
        float result;
        switch (symbol){
            case "+":
                result = first + second;
                System.out.println(first + symbol + second +" = " + result);
                break;
            case "-":
                result = first - second;
                System.out.println(first + symbol + second +" = " + result);
                break;
            case "*":
                result = first * second;
                System.out.println(first + symbol + second +" = " + result);
                break;
            case "/":
                if(second != 0){
                    result = (float) first / (float) second;
                    System.out.printf("%d %s %d = %.2f \n",first,symbol,second,result);
                    //System.out.println(first + symbol + second +" = " + result);
                } else System.out.println("На 0 делить нелья!");
                break;
            default:
                System.out.println("Я такую операцию не умею");
        }
    }
}
