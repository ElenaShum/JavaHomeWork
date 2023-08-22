import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите число ");
        int number = sc.nextInt();

        if (number >= 0 && number <= 14) {
            System.out.println("Номер находится в промежутке [0 -14]");
        } else if (number >= 15 && number <= 35) {
            System.out.println("Номер находится в промежутке [15 - 35]");
        } else if (number >= 36 && number < 50) {
            System.out.println("Номер находится в промежутке 36 - 50]");
        } else if (number >= 50 && number <= 100) {
            System.out.println("Номер находится в промежутке [50 - 100]");
        } else {
            System.out.println("Номер не входит не в один из имеющихся промежутков");
        }
    }
}



