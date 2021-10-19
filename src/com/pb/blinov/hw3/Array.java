package com.pb.blinov.hw3;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        int[] arr = new int[10];
        String ans;
        Scanner scan = new Scanner(System.in);
        int i = 0;
        do{
            System.out.println("Осталось ввести " + (arr.length-i) + ". Введите число");
            ans = scan.next();
            try {
                arr[i] = Integer.parseInt(ans);
            } catch (NumberFormatException e) {
                System.err.println("Вводите только числа");
                continue;
            }
            i++;
        }
        while (i < arr.length);
        System.out.println("Введенный массив: " +Arrays.toString(arr));
        int summa = 0;
        for(i = 0; i < arr.length; i++){
            summa+=arr[i];
        }
        System.out.println("Сумма чисел " + summa);
        int countPositive = 0;
        for(i = 0; i < arr.length; i++){
            if(arr[i]>0){
                countPositive++;
            }
        }
        System.out.println("Количество положительных " + countPositive);
        boolean isSorted = false;
        int tmp;
        while(!isSorted) {
            isSorted = true;
            for (i = 0; i < arr.length-1; i++) {
                if(arr[i] > arr[i+1]){
                    isSorted = false;
                    tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
        }
        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
    }
}
