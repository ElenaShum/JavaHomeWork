import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        System.out.println("Угадайте число от 1 до 100 или введите out для выхода из программы");

        int attempt = 0; // кол-во попыток
        // загадываем число
        Random rand = new Random();
        int x = 0;
        x = rand.nextInt(100) + 1 ;
        Scanner sc = new Scanner(System.in);

        int number = 0;


        while (true) {
            attempt++;
            System.out.println("Попытка " + attempt + ":");
            String in = sc.next();


            if (in.equals("out")) {
                System.out.println("Программа окончена");
                break;
            }

            try {
                 number = Integer.parseInt(in);
            } catch (Exception e) {
                System.out.println("Вы ввели не число (" + in + ")");
            }



            if (number > x) {
                System.out.println("Искомое число меньше");
                continue;
            }

            if (number < x) {
                System.out.println("Искомое число больше");
                continue;
            }

            //if (number != x) {
            //    continue;
            //}

            System.out.println("Вы угадали с " + attempt + " попытки");
            break;
        }
    }
}





