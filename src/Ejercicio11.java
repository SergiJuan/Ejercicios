import java.util.Scanner;

public class Ejercicio11 {

    public static final char[] LETTERS = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    public static int intentosAcertados = 0;

    public static void main(String[] args) {
        String[][] array = new String[9][9];
        boolean[][] disparos = new boolean[9][9];
        boolean[][] barcos = new boolean[9][9];
        int intentosDisparo = 0;


        // Generar
        addShips(barcos);

        while (true) {
            contructTable(array, disparos, barcos);

            // Mostrar
            System.out.println("Disparos: "+intentosDisparo);
            System.out.println("Aciertos: "+intentosAcertados);
            printTable(array);

            // Disparo
            do {
                intentosDisparo++;
            } while (getDisparo(disparos, barcos));
        }

    }

    static void addShips(boolean[][] barcos) {
        int barcosColocados = 0;
        while (barcosColocados < 10) {
            int fila = (int) (Math.random() * 9);
            int columna = (int) (Math.random() * 9);

            if (!barcos[fila][columna]) {
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
                        array[i][j] = "✖";
                    } else {
                        array[i][j] = "▣";
                    }
                } else {
                    array[i][j] = "□";
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
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(" "+array[i][j]+" ");
            }
            System.out.println();
        }
    }

    static boolean getDisparo(boolean[][] disparos, boolean[][] barcos) {
        Scanner input = new Scanner(System.in);
        String coords;

        System.out.print("Introduce coordenada del disparo (A,1): ");
        coords = input.next();
        String[] coordsArray = coords.split(",");


        String letterString = String.valueOf(LETTERS);

        try {
            if (letterString.contains(coordsArray[0]) && (Integer.parseInt(coordsArray[1]) >= 1 && Integer.parseInt(coordsArray[1]) <= 8)) {
                System.out.println("--> Disparo realizado!");

                int letterInt = 1;
                for (int i = letterInt; i < 9; i++) {
                    if (coordsArray[0].equalsIgnoreCase(String.valueOf(LETTERS[i]))) {
                        break;
                    }
                    letterInt++;
                }

                disparos[letterInt][Integer.parseInt(coordsArray[1])] = true;


                if (disparos[letterInt][Integer.parseInt(coordsArray[1])] == barcos[letterInt][Integer.parseInt(coordsArray[1])]) {
                    System.out.println("¡BARCO ALCANZADO!");
                    intentosAcertados++;
                }

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
}
