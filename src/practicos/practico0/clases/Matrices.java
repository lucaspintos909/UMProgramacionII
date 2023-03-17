package practicos.practico0.clases;

public class Matrices {
    public static void desplegar(int[][] matriz) {
        /* [[],[],[]]] */
        for (int[] fila : matriz) {
            for (int num : fila) {
                System.out.printf("%d ", num);
            }
            System.out.println(" ");
        }
    }

    public static int filas(int[][] matriz) {
        return matriz.length;
    }

    public static int columnas(int[][] matriz) {
        return matriz[0].length;
    }

    public static boolean esCuadrada(int[][] matriz) {
        boolean result = true;
        int cantFilas = filas(matriz);

        for (int[] fila : matriz) {
            if (fila.length != cantFilas) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean esValida(int[][] matriz) {
        /*
        * Esta funcion chequea si la cantidad de columas de cada fila es la misma
        */
        boolean esValida = true;
        int cantidadColumnas = matriz[0].length;

        for (int[] fila : matriz) {
            if (fila.length != cantidadColumnas) {
                esValida = false;
                break;
            }
        }
        return esValida;
    }

    public static int[][] sumar(int[][] matrizA, int[][] matrizB) {
        int[][] matrizSuma = new int[filas(matrizA)][columnas(matrizA)];

        /* Verificar si las dos matrices son válidas y son de la misma dimension */
        if (!esValida(matrizA) || !esValida(matrizB)) {
            return null;
        }

        if (filas(matrizA) != filas(matrizB) || columnas(matrizA) != columnas(matrizB)){
            return null;
        }


        /* Sumar las matrices */
        for(int fila = 0; fila < matrizSuma.length; fila++){
            for(int columna = 0; columna < matrizSuma[0].length; columna++) {
                matrizSuma[fila][columna] = matrizA[fila][columna] + matrizB[fila][columna];
            }
        }

        return matrizSuma;
    }
}
