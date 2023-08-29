/*
Используя IntelliJ IDEA, создайте класс Anagram.
Напишите программу, которая определяет, является ли одна строка анаграммой другой строки.
Анаграмма - это слово или фраза, сделанная путем переноса букв другого слова или фразы.
Программа должна игнорировать пробелы и знаки препинания.
Пример анаграмм:

Аз есмь строка, живу я, мерой остр.
За семь морей ростка я вижу рост.

Я в мире — сирота.
Я в Риме — Ариост.

 */


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Anagram {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.println("Введите первую фразу: ");
        String firstPhrase = sc.nextLine();

        System.out.println("Введите вторую фразу: ");
        String secondPhrase = sc.nextLine();


        HashMap<Character, Integer> firstPhraseMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> secondPhraseMap = new HashMap<Character, Integer>();

        for (int i = 0; i < firstPhrase.length(); i++) {

            int a = 0;

            for (int j = 0; j < firstPhrase.length(); j++) {

                if (Character.toLowerCase(firstPhrase.charAt(i)) == Character.toLowerCase(firstPhrase.charAt(j))
                        && Character.isLetter(firstPhrase.charAt(i))) {
                    a++;
                }
            }
            if (Character.isLetter(firstPhrase.charAt(i))) {
                firstPhraseMap.putIfAbsent(Character.toLowerCase(firstPhrase.charAt(i)), a);
            }
        }
        for (int i = 0; i < secondPhrase.length(); i++) {
            int a = 0;

            for (int j = 0; j < secondPhrase.length(); j++) {
                if (Character.toLowerCase(secondPhrase.charAt(i)) == Character.toLowerCase(secondPhrase.charAt(j))
                        && Character.isLetter(secondPhrase.charAt(i))) {
                    a++;
                }
            }
            if (Character.isLetter(secondPhrase.charAt(i))) {

                secondPhraseMap.putIfAbsent(Character.toLowerCase(secondPhrase.charAt(i)), a);
            }
        }

        // проверяем как выглядят мапы
        /*for (Map.Entry entry : firstPhraseMap.entrySet()) {
            System.out.println(entry.getKey()+ " " + entry.getValue());
        }
        System.out.println("-----");
        for (Map.Entry entry : secondPhraseMap.entrySet()) {
            System.out.println(entry.getKey()+ " " + entry.getValue());
        }*/


        System.out.println(firstPhraseMap.equals(secondPhraseMap));
    }
}
