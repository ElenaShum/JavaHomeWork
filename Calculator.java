
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        double operand1;
        double operand2;
        String sign;
        double sum = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите первое число: ");
        operand1 = sc.nextInt();

        System.out.println("Введите второе число: ");
        operand2 = sc.nextInt();

        System.out.println("Введите знак: ");
        sign = sc.next();


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
                if (operand2 != 0) {
                    sum = operand1 / operand2;
                } else {
                    System.out.println("Деление на ноль невозможно");

                }
        }
        System.out.println(sum);
    }
}


}
