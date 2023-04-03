package TADs.LinkedList;

import TADs.interfaces.LinkedListInterface;

public class LinkedList<T> implements LinkedListInterface<T> {
    private Node<T> head;

    @Override
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.prev = null;

        if (head == null) {
            head = newNode;
            return;
        }

        Node<T> last = head;
        // Voy hasta el final de la lista
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        newNode.prev = last;
        newNode.next = head;
        head.prev = newNode;
    }

    @Override
    public void remove(Integer position) {
        Node<T> prev = getHead();

        if (position == 0) {
            head = head.next;
        } else {
            /* position - 1 porque necesito el nodo anterior al que voy a eliminar */
            for (int index = 0; index < position - 1; index++) {
                prev = prev.next;
            }

            Node<T> prox = prev.next;
            prev.next = prox.next;
        }
    }

    @Override
    public T get(Integer position) {
        Node<T> it = getHead();

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

        newNode.next = getHead();
        newNode.prev = null;

        head = newNode;
    }

    @Override
    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.value = value;
        newNode.next = null;

        Node<T> last = getHead();
        while (last.next != null) {
            last = last.next;
        }
        newNode.prev = last;
        last.next = newNode;

    }

    @Override
    public boolean exists(T value) {
        Node<T> it = getHead();
        boolean valueExists = false;

        while (it.next != null) {
            if (it.value.equals(value)) {
                valueExists = true;
                break;
            }
            it = it.next;
        }

        return valueExists;
    }

    public Node<T> getHead() {
        return head;
    }
}
