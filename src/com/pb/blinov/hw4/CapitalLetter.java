package com.pb.blinov.hw4;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalLetter {

    static String capitalize(String text){
//        String result = "";
//        String[] words = text.split(" ");
//        for(String word : words){
//            result = result + word.substring(0,1).toUpperCase()+word.substring(1)+' ';
//        };
//        return result;
//        Делать было нечего дело было вечером, поэтому оставим рабочий вариант 2
        String pattern = "^(\\p{L})|\\s(\\p{L})";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        StringBuffer sb = new StringBuffer();
        while(m.find()) {
            m.appendReplacement(sb,m.group().toUpperCase());
        }
        m.appendTail(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1;
        System.out.println("Введите первую строку");
        str1 = scan.nextLine();
        System.out.println(capitalize(str1));
//        System.out.println(capitalize("Истина — это то, что выдерживает проверку опытом. Эйнштейн А."));
    }
}
