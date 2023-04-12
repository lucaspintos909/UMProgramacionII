package TADs.interfaces;

import java.util.EmptyStackException;

public interface StackInterface<T> {
    void pop() throws EmptyStackException;

    T top() throws EmptyStackException;

    void push(T element);

    boolean isEmpty();

    void makeEmpty();
}