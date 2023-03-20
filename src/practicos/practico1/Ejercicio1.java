package practicos.practico1;

import TADs.LinkedList.LinkedList;
import TADs.LinkedList.Node;

public class Ejercicio1 {

    public static void main(String[] args) {
        LinkedList lista = new LinkedList();
        lista.add(10);
        lista.add(20);
        lista.add(30);
        lista.add(40);
        /*lista.addFirst(5);
        lista.addLast(50);*/

        /*lista.remove(2);*/
        Object valorPosicion1 = lista.get(1);

        Node n = lista.getHead();
        Node prev;

        while (n.next != null) {
            prev = n.prev;
            System.out.println("Valor: " + n.value);
            if (n.prev != null) {
                System.out.println("Valor previo de " + n.value + ": " + prev.value);
            }
            n = n.next;
        }
        prev = n.prev;
        System.out.println("Valor: " + n.value);
        System.out.println("Valor previo de " + n.value + ": " + prev.value);

        System.out.println("Existe el 1: " + lista.exists(1));
        System.out.println("Obteniendo valor de la posicion 1: " + valorPosicion1);
    }
}
