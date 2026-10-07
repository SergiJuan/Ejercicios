public class Ejercicio9 {
    public static void main(String[] args) {
        int[][] array = new int[10][10];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = 1;
            }
        }

        array[0][4] = 8;
        array[2][6] = 8;
        array[3][1] = 8;
        array[8][6] = 8;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(" "+array[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();

        int rowsItemCount = 0;
        int rows = 0;

        int columnsItemCount = 0;
        int columns = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 8) {
                    break;
                } else {
                    rowsItemCount++;
                }
                if (rowsItemCount >= array[0].length) {
                    rows++;
                }

            }
            rowsItemCount = 0;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[j][i] == 8) {
                    break;
                } else {
                    columnsItemCount++;
                }
                if (columnsItemCount >= array[0].length) {
                    columns++;
                }

            }
            columnsItemCount = 0;
        }

        System.out.println("Columns 1: "+columns);
        System.out.println("Rows 1: "+rows);

    }
}
