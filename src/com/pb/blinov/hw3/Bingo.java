package com.pb.blinov.hw3;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        Random random = new Random();
        int enigma = random.nextInt(101);
        int diff = 0;
        Scanner scan = new Scanner(System.in);
        String answer;
        int gues;
        int attempts = 0;
        do{
            System.out.println("Введите число от 1 до 100. Или знак ! для выхода.");
            answer = scan.next();
            if(answer.equals("!")){
                break;
            }
            try {
                gues = Integer.parseInt(answer);
            } catch (NumberFormatException e) {
                System.err.println("Моя твоя не понимать. Попробуй еще раз!");
                continue;
            }
            attempts++;
            diff = enigma - gues;
            if (diff < 0){
                System.out.println("Загаданное число меньше");
            } else if(diff > 0){
                System.out.println("Загаданное число больше");
            } else {
                System.out.println("Поздравляю число угадано за " + attempts + " попыток.");
            }
        }
        while (diff != 0);
        System.out.println("Досвиданья. Заходи ещё.");
    }
}
