package practicos.practico0;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio2 {
    /*
    2. Genere una clase Solicitud que solicite números en entrada estándar cuando el usuario
    ingrese un -1 se terminará el mismo, deplegando la siguiente información:
        • mayor número introducido
        • menor número introducido
        • suma de todos los números
        • suma de los números positivos
        • suma de los números negativos
        • promedio de los números
*/
    public static Integer pedirNumero(Scanner scanner) {
        System.out.println("Ingrese un número: ");
        String entrada = scanner.nextLine();
        return Integer.parseInt(entrada);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();
        int numIngresado = 0;
        int numeroMenor;
        int numeroMayor;
        int suma = 0;
        int sumaPositivos = 0;
        int sumaNegativos = 0;
        double promedio;


        while (numIngresado != -1) {
            numIngresado = pedirNumero(scanner);
            if (numIngresado != -1) {
                numeros.add(numIngresado);
            }
        }
        numeroMayor = Collections.max(numeros);
        numeroMenor = Collections.min(numeros);

        for (int numLista : numeros) {
            suma += numLista;
            if (numLista >= 0) {
                sumaPositivos += numLista;
            }
            if (numLista < 0) {
                sumaNegativos += numLista;
            }
        }
        promedio = (double) (suma) / (double) (numeros.size());


        System.out.println("\n\n\n");
        System.out.println(numeros);
        System.out.println("Número mayor: " + numeroMayor);
        System.out.println("Número menor: " + numeroMenor);
        System.out.println("Suma: " + suma);
        System.out.println("Suma positivos: " + sumaPositivos);
        System.out.println("Suma negativos: " + sumaNegativos);
        System.out.println("Promedio: " + promedio);
    }
}
