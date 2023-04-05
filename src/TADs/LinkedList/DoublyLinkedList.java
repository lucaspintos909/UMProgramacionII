package TADs.LinkedList;
import java.util.LinkedList;

import TADs.exceptions.IndexOutOfRange;
import TADs.interfaces.LinkedListInterface;

public class DoublyLinkedList<T> implements LinkedListInterface<T> {
    private Node<T> head;

    public void display() {
        Node<T> node = head;
        Node<T> last = null;
        while (node != null) {
            System.out.print(node.value + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");

        System.out.println("Print in reverse");
        while (last != null) {
            System.out.print(last.value + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }

    public Integer size() {
        Integer listSize = 0;
        Node<T> aux = head;

        if (aux == null) {
            return listSize;
        }

        while (aux.next != null) {
            aux = aux.next;
            listSize++;
        }
        listSize++;

        return listSize;
    }

    public void positionIsValid(Integer position) throws IndexOutOfRange {
        if (position < 0 || position >= size()) {
            String message = "IndexError: index out of range: " + position;
            throw new IndexOutOfRange(message);
        }
    }

    @Override
    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node<T> aux = head;
        // Voy hasta el final de la lista
        while (aux.next != null) {
            aux = aux.next;
        }
        aux.next = newNode;
        newNode.prev = aux;
    }

    @Override
    public void remove(Integer position) throws IndexOutOfRange {
        positionIsValid(position);
        Node<T> prev = head;

        if (position == 0) {
            head = head.next;
            head.prev = null;
            return;
        }

        for (int index = 0; index < position - 1; index++) {
            prev = prev.next;
        }

        Node<T> prox = prev.next;
        prev.next = prox.next;

    }

    @Override
    public T get(Integer position) {
        Node<T> it = head;

        if (position == 0) {
            return head.value;
        }

        for (int index = 0; index < position; index++) {
            it = it.next;
        }

        return it.value;
    }

    @Override
    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);

        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    @Override
    public void addLast(T value) {
        add(value);
    }

    @Override
    public boolean exists(T value) {
        Node<T> aux = head;
        boolean valueExists = false;

        do {
            if (aux.value.equals(value)) {
                valueExists = true;
                break;
            }
            aux = aux.next;
        } while (aux != null);

        return valueExists;
    }

    public Node<T> getHead() {
        return head;
    }
}
