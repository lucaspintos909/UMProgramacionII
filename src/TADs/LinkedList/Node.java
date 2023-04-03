package TADs.LinkedList;

public class Node<T> {
    T value;
    Node<T> next;
    Node<T> prev;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrev() {
        return prev;
    }
}