package practicos.practico0;

import practicos.practico0.clases.Matrices;

public class Ejercicio4 {
    /*
      4. Se	debe	generar	una	clase Matrices	que	tenga	las	siguientes	operaciones:
        • public	void desplegar(int[][]	matriz);
        i. Despliega	en	salida	estándar	el	contenido	de	la	matriz.	Elija	el	formato,
        respetando	de	colocar	una	linea	por	cada	fila.
        • public	boolean	esCuadrada(int[][]	matriz);
        i. Retorna	true	si	la	matriz	es	cuadrada,	false	en	caso	contrario.
        • public	int	filas(int[][]	matriz);
        i. Retorna	la	cantidad	de	filas	de	la	matriz
        • public	int	columnas(matriz);
        i. Retorna	la	cantidad	de	columnas	de	la	matriz
        • public int[][] sumar(int[][]	matrizA,	int[][]	matrizB);
        i. Retorna	la	matriz	resultado	de	sumar	matrizA	+	matrizB.	En	caso	que	las
        matrices	tengan	distintas	dimensiones	se	debe	retornar	null.

    */

    public static void main(String[] args) {
        int[][] list = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        int[][] list2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};

        int[][] sumaDeMatrices = Matrices.sumar(list, list2);

        System.out.println("Matriz 1");
        Matrices.desplegar(list);
        System.out.println("\nMatriz 2");
        Matrices.desplegar(list2);

        System.out.printf("\nLa matriz 1 es cuadrada: %b \n", Matrices.esCuadrada(list));
        System.out.printf("La matriz 2 es cuadrada: %b \n", Matrices.esCuadrada(list2));

        System.out.println("\nSuma de matriz 1 y 2");
        if (sumaDeMatrices != null) {
            Matrices.desplegar(sumaDeMatrices);
        }else{
            System.out.println("No se puede realizar la suma de matrices por tener diferentes dimensiones.");
        }

    }
}
