import java.util.Arrays;

public class Ejercicio10 {

    static final char[] LETTERS = {'B', 'A', 'B', 'C', 'A', 'C', 'D', 'C', 'C', 'D', 'Y', 'O', 'L', 'L', 'A', 'A', 'B', 'C', 'C', 'D'};

    public static void main(String[] args) {

        int[] modes = new int[LETTERS.length];

        for (int i = 0; i < LETTERS.length; i++) {
            int count = 0;
            for (int j = 0; j < LETTERS.length; j++) {
                if (LETTERS[j] == LETTERS[i]) {
                    count++;
                }
            }
            modes[i] = count;
        }

        int giant = 0;
        for (int i = 0; i < modes.length; i++) {
            if (modes[i] >= modes[giant]) {
                giant = i;
            }
        }

        System.out.println("El caracter mas repetido es: " + LETTERS[giant]);

    }
}
