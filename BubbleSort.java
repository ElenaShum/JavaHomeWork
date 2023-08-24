import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {


        int[] array = new int[10];

        Scanner sc = new Scanner(System.in);
        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            counter++;
            System.out.println("Введите " + counter + " число для массива:");
            array[i] = sc.nextInt();
        }

        boolean isSorted = false;
        int tmp = 0;
        while (!isSorted) {
            isSorted = true;
            for (int j = 1; j < array.length; j++) {

                if (array[j] < array[j - 1]) {
                    isSorted = false;
                    tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }

        System.out.println("Мы получили массив: " + Arrays.toString(array));
    }
}
