package practicos.practico1;
import TADs.LinkedList.CircularLinkedList;
public class Ejercicio6 {
    public static void main(String[] args) {
        CircularLinkedList<Integer> lista = new CircularLinkedList<>();

        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);

        lista.display();
    }
}
