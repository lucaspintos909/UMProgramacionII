package TADs.LinkedList;

import TADs.interfaces.LinkedListInterface;
import TADs.exceptions.IndexOutOfRange;

public class CircularLinkedList<T> implements LinkedListInterface<T> {

    private Node<T> head;
    private Node<T> tail;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public Integer size() {
        Integer listSize = 0;
        Node<T> auxSize = head;

        if (auxSize == null) {
            return listSize;
        }

        do {
            auxSize = auxSize.next;
            listSize++;
        } while (auxSize != head);

        return listSize;
    }

    public void positionIsValid(Integer position) throws IndexOutOfRange {
        if (position < 0 || position >= size()) {
            String message = "IndexError: index out of range: " + position;
            throw new IndexOutOfRange(message);
        }
    }

    public boolean exists(T value) {
        boolean result = false;
        Node<T> aux = head;

        while (aux != tail) {
            if (aux.value.equals(value)) {
                result = true;
                break;
            }
            aux = aux.next;
        }

        if (aux.value.equals(value)) {
            result = true;
        }

        return result;
    }

    @Override
    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        /* El nuevo nuevo nodo va a apuntar a Head */
        newNode.next = head;
        /* Tail siempre apunta a Head (ahora, el nuevo nodo) */
        tail.next = newNode;
        /* Head pasa a ser el nuevo nodo */
        head = newNode;
    }

    @Override
    public void addLast(T value) {
        add(value); // xd

        /*if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        *//* Tail siempre apunta a Head *//*
        newNode.next = head;
        *//* Tail pasa a apunta al nuevo nodo *//*
        tail.next = newNode;
        *//* El nuevo nodo pasa a ser Tail *//*
        tail = newNode;*/
    }

    @Override
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        // Apunto el nuevo nodo al next del ultimo elemento.
        tail.next = newNode;
        // Apunto el next del nuevo nodo al head (el primer nodo).
        newNode.next = head;
        // El nodo final pasa a ser el nuevo nodo.
        tail = newNode;
    }

    @Override
    public void remove(Integer position) throws IndexOutOfRange {
        positionIsValid(position);
        Node<T> aux = head;

        if (position == 0) {
            head = head.next;
            tail.next = head;
            return;
        }

        for (int index = 0; index < position - 1; index++) {
            aux = aux.next;
        }
        Node<T> prox = aux.next;
        aux.next = prox.next;
    }

/*    @Override
    public void deleteValue(T val) {
        Node<T> node = head;
        if (node == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        if (node.value == val) {
            head = head.next;
            tail.next = head;
            return;
        }

        do {
            Node<T> n = node.next;
            if (n.value == val) {
                node.next = n.next;
                break;
            }
            node = node.next;
        } while (node != head);

    }*/

    @Override
    public T get(Integer position) {
        Node<T> aux = head;
        T value = null;
        Integer index = 0;
        do {
            if (index.equals(position)) {
                value = aux.value;
                break;
            }
            aux = aux.next;
            index++;
        } while (aux != head);

        return value;
    }

    public void display() {
        Node<T> node = head;
        if (head != null) {
            do {
                System.out.print(node.value + " -> ");
                if (node.next != null) {
                    node = node.next;
                }
            } while (node != head);
        }
        System.out.println("HEAD");
    }


    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }
}
