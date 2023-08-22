
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        double operand1;
        double operand2;
        String sign;
        double sum = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите первое число ");
        operand1 = sc.nextInt();

        System.out.println("Введите второе число ");
        operand2 = sc.nextInt();

        System.out.println("Введите знак ");
        sign = sc.next();

        if (operand2 != 0) {
            switch (sign) {
                case "+":
                    sum = operand1 + operand2;
                    break;
                case "-":
                    sum = operand1 - operand2;
                    break;
                case "*":
                    sum = operand1 * operand2;
                    break;
                case "/":
                    sum = operand1 / operand2;


            }
            System.out.println(sum);
        } else {
            System.out.println("Деление на ноль невозможно");
        }


    }


}
