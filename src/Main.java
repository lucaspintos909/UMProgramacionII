import TADs.LinkedList.LinkedList;
import TADs.LinkedList.Node;

public class Main {
    public static void main(String[] args) {
        LinkedList lista = new LinkedList();
        lista.add(10);
        lista.add(20);
        lista.add(30);
        lista.add(40);
        lista.addFirst(5);
        lista.addLast(50);

        Node n = lista.getHead();

        while (n.next != null) {
            System.out.println(n.value);
            n = n.next;
        }
        System.out.println(n.value);
        System.out.println("Existe el 1: " + lista.exists(1));

    }
}