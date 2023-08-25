
/*
Используя IntelliJ IDEA, создайте класс CapitalLetter.
Напишите программу, которая принимает строку и переводит первую букву слова в верхний регистр.
Пример работы:
Истина — это то, что выдерживает проверку опытом. Эйнштейн А.
Истина — Это То, Что Выдерживает Проверку Опытом. Эйнштейн А.
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CapitalLetter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст: ");

        String text = sc.nextLine();

        char[] charArray = text.toCharArray();

        //System.out.println(Arrays.toString(charArray));
        charArray[0] = Character.toUpperCase(charArray[0]);

        for (int i = 0; i < charArray.length-1; i++) {

            if (charArray[i] == ' ') {
                charArray[i+1] = Character.toUpperCase(charArray[i+1]);
            }
        }

        //System.out.println(Arrays.toString(charArray));

        StringBuilder buf = new StringBuilder();

        for (char c : charArray) {
            buf.append(c);
        }

        System.out.println(buf);

        }
    }

