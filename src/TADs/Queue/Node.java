package TADs.Queue;

public class Node<T> {
    T value;
    Node<T> prev;

    public Node(T value) {
        this.value = value;
        this.prev = null;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getPrev() {
        return prev;
    }
}