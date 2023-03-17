package TADs.LinkedList;
import TADs.interfaces.LinkedListInterface;

public class LinkedList implements LinkedListInterface {
    public Node head;

    @Override
    public void add(Object value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = null;

        if (head != null) {
            Node it = getHead();
            while (it.next != null) {
                it = it.next;
            }
            it.next = newNode;
        } else {
            head = newNode;
        }
    }

    @Override
    public void remove(Integer position) {
        Node prev = getHead();

        if (position == 0) {
            head = head.next;
        } else {
            /* position - 1 porque necesito el nodo anterior al que voy a eliminar */
            for (int index = 0; index < position - 1; index++) {
                prev = prev.next;
            }

            Node prox = prev.next;
            prev.next = prox.next;
        }
    }

    @Override
    public Object get(Integer position) {
        Node it = getHead();

        if (position == 0) {
            return head;
        }
        for (int index = 0; index < position; index++) {
            it = it.next;
        }

        return it.value;
    }

    @Override
    public void addFirst(Object value) {
        Node newNode = new Node();

        newNode.value = value;
        newNode.next = getHead();

        head = newNode;
    }

    @Override
    public void addLast(Object value) {
        Node newNode = new Node();
        newNode.value = value;

        Node it = getHead();
        while (it.next != null){
            it = it.next;
        }
        it.next = newNode;
    }

    @Override
    public boolean exists(Object value) {
        Node it = getHead();
        boolean valueExists = false;

        while (it.next != null){
            if(it.value == value){
                valueExists = true;
                break;
            }
            it = it.next;
        }

        return valueExists;
    }

    public Node getHead() {
        return head;
    }
}
