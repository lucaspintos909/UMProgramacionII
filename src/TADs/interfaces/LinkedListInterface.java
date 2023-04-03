package TADs.interfaces;

import TADs.exceptions.IndexOutOfRange;

public interface LinkedListInterface<T> {
    void add(T value);

    void remove(Integer position) throws IndexOutOfRange;

    T get(Integer position);

    boolean exists(T value);

    void addFirst(T value);

    void addLast(T value);
}
