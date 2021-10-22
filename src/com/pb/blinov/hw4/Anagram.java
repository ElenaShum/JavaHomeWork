package com.pb.blinov.hw4;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Anagram {

    static char[] strToArr(String str){
        return str.replaceAll("\\p{Punct}|\\s","").toLowerCase().toCharArray();
    }

    static boolean comparator(String a, String b){
        char[] arra = strToArr(a);
        char[] arrb = strToArr(b);
        Arrays.sort(arra);
        Arrays.sort(arrb);
        return Arrays.equals(arra,arrb);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1;
        String str2;
//        str1 = "✈ Самолёт Эмоджи";
//        str2 = "Эмоджи ✈ Самолёт";
        System.out.println("Введите первую строку");
        str1 = scan.nextLine();
        System.out.println("Введите вторую строку");
        str2 = scan.nextLine();
        System.out.println("Первая строка: "+str1);
        System.out.println("Вторая строка: "+str2);
        if(comparator(str1,str2)){
            System.out.println("Строки равны");
        } else System.out.println("Строки не равны");
    }
}
