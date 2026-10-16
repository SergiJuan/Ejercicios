import java.util.Scanner;

public class Ejercicio11 {

    public static final char[] LETTERS = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    public static final String SYMBOL_EMPTY = "□";
    public static final String SYMBOL_DISPARO = "▣";
    public static final String SYMBOL_DISPARO_ACERTADO = "✖";

    public static final int TABLERO_TAMANO = 9;

    public static int intentosAcertados = 0;
    public static int intentosDisparo = 0;;

    public static void main(String[] args) {
        String[][] array = new String[TABLERO_TAMANO][TABLERO_TAMANO];
        boolean[][] disparos = new boolean[TABLERO_TAMANO][TABLERO_TAMANO];
        boolean[][] barcos = new boolean[TABLERO_TAMANO][TABLERO_TAMANO];

        // Generar
        addShips(barcos);

        while (intentosAcertados < 10) {
            contructTable(array, disparos, barcos);

            // Mostrar
            printTable(array);

            // Disparo
            while (getDisparo(array, disparos, barcos)) {};
        }

        winGame(array);

    }

    static void addShips(boolean[][] barcos) {
        int barcosColocados = 0;
        while (barcosColocados < 10) {
            int fila = (int) (Math.random() * TABLERO_TAMANO);
            int columna = (int) (Math.random() * TABLERO_TAMANO);

            if (!barcos[fila][columna] && !(fila == 0 || columna == 0)) {
                barcos[fila][columna] = true;
                barcosColocados++;
            }
        }
    }

    static void contructTable(String[][] array, boolean[][] disparos, boolean[][] barcos) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (disparos[i][j]) {
                    if (barcos[i][j]) {
                        array[i][j] = SYMBOL_DISPARO_ACERTADO;
                    } else {
                        array[i][j] = SYMBOL_DISPARO;
                    }
                } else {
                    array[i][j] = SYMBOL_EMPTY;
                }
            }
        }

        // ---
        for (int i = 1; i <= 8; i++) {
            array[0][i] = ""+i;
        }


        for (int i = 0; i < 9; i++) {
            array[i][0] = ""+ LETTERS[i];
        }
    }

    static void printTable(String[][] array) {
        System.out.println("Disparos: "+intentosDisparo);
        System.out.println("Aciertos: "+intentosAcertados);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(" "+array[i][j]+" ");
            }
            System.out.println();
        }
    }

    static boolean getDisparo(String[][] array, boolean[][] disparos, boolean[][] barcos) {
        Scanner input = new Scanner(System.in);
        String coords;

        System.out.print("Introduce coordenada del disparo (A,1): ");
        coords = input.next();
        String[] coordsArray = coords.split(",");


        String letterString = String.valueOf(LETTERS);

        try {
            int numberInt = Integer.parseInt(coordsArray[1]);

            if (letterString.contains(coordsArray[0]) && (numberInt >= 1 && numberInt <= 8)) {
                int letterInt = 1;
                for (int i = letterInt; i < 9; i++) {
                    if (coordsArray[0].equalsIgnoreCase(String.valueOf(LETTERS[i]))) {
                        break;
                    }
                    letterInt++;
                }

                if (array[letterInt][numberInt].equals(SYMBOL_DISPARO_ACERTADO) || array[letterInt][numberInt].equals(SYMBOL_DISPARO)){
                    System.out.println("¡Ya habias disparado aqui antes!");
                    return true;
                }

                System.out.println("--> Disparo realizado!");
                disparos[letterInt][numberInt] = true;

                if (disparos[letterInt][numberInt] == barcos[letterInt][numberInt]) {
                    System.out.println("¡BARCO ALCANZADO!");
                    intentosAcertados++;
                }
                intentosDisparo++;
                return false;

            } else {
                System.out.println("¡Coordenadas Incorrectas!");
                return true;
            }
        } catch (Exception e) {
            System.out.println("¡Coordenadas Invalidas!");
        }
        return true;

    }

    static void winGame(String[][] array) {
        printTable(array);
        System.out.println("""
                -----
                FELICIDADES!! - HAS HUNDIDO TODOS LOS BARCOS
                -----
                """);
        System.out.println("Disparos: "+intentosDisparo);
        System.out.println("Aciertos: "+intentosAcertados);
    }
}
