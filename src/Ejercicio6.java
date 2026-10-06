import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            System.out.print("Introduce a number [" + i + "]: ");
            array[i] = input.nextInt();
        }

        System.out.println("Array orden normal:");
        System.out.println(Arrays.toString(array));

        int x = array.length - 1;
        int temp;
        for (int i = 0; i < (array.length / 2); i++) {
            temp = array[i];
            array[i] = array[x];
            array[x] = temp;
            x--;
        }

        System.out.println("Array orden invertido:");
        System.out.println(Arrays.toString(array));


        System.out.println("Array impreso en orden normal:");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + ", ");
        }
    }
}
