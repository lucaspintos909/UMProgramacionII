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
        lista.addFirst(5);
        lista.addLast(50);

        lista.remove(2);
        Object valorPosicion1 = lista.get(1);

        Node n = lista.getHead();

        while (n.next != null) {
            System.out.println(n.value);
            n = n.next;
        }
        System.out.println(n.value);
        System.out.println("Existe el 1: " + lista.exists(1));
        System.out.println("Obteniendo valor de la posicion 1: " + valorPosicion1);
    }
}
