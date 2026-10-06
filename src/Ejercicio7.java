import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        int dni;
        String[] index_letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        Scanner input = new Scanner(System.in);

        System.out.print("Introduce el numero del DNI: ");
        dni = input.nextInt();

        System.out.println("Tu letra del DNI calculada es: " + index_letras[dni % 23] + " -> " + dni + index_letras[dni % 23]);

    }
}
