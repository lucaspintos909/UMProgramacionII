package TADs.Stack;

import TADs.interfaces.StackInterface;

import java.util.EmptyStackException;

public class Stack<T> implements StackInterface<T> {
    Node<T> tail;

    @Override
    public void pop() throws EmptyStackException {
        if (tail == null) {
            throw new EmptyStackException();
        }

        tail = tail.prev;
    }

    @Override
    public T top() throws EmptyStackException {
        return this.tail.value;
    }

    @Override
    public void push(T element) {
        Node<T> newNode = new Node<>(element);

        if (this.tail == null) {
            this.tail = newNode;
            return;
        }

        newNode.prev = this.tail;
        this.tail = newNode;
    }

    @Override
    public boolean isEmpty() {
        return tail == null;
    }

    @Override
    public void makeEmpty() {
        tail = null;
    }

    public void display() {
        Node<T> aux = tail;
        System.out.print("TOP ");
        if (tail != null) {
            do {
                System.out.print(aux.value + " <- ");

                aux = aux.prev;

            } while (aux != null);
        } else {
            System.out.print("NULL ");
        }
        System.out.print("PRINCIPIO\n");
    }

    public Node<T> getTail() {
        return tail;
    }
}
