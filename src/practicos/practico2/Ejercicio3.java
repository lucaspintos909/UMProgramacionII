package practicos.practico2;

import TADs.Stack.Stack;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        String texto;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese texto: ");
        texto = scanner.nextLine();

        System.out.println(verificar(texto));
    }

    static boolean verificar(String texto) {
        String[] listaCaracteres = texto.split("");
        Stack<String> listaDeLlaves = new Stack<>();


        for (String caracter : listaCaracteres) {
            if ("({[".contains(caracter)) {
                listaDeLlaves.push(caracter);
            } else if ("]})".contains(caracter)) {
                if (listaDeLlaves.isEmpty()){
                    return false;
                }
                if (caracter.equals(")") && listaDeLlaves.top().equals("(")){
                    listaDeLlaves.pop();
                }
                if (caracter.equals("}") && listaDeLlaves.top().equals("{")){
                    listaDeLlaves.pop();
                }
                if (caracter.equals("]") && listaDeLlaves.top().equals("[")){
                    listaDeLlaves.pop();
                }
            }
        }
        return listaDeLlaves.isEmpty();
    }
}