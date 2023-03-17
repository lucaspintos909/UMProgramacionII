package TADs.interfaces;

public interface LinkedListInterface {
    void add(Object value);

    void remove(Integer position);

    Object get(Integer position);

    boolean exists(Object value);

    void addFirst(Object value);
    void addLast(Object value);
}
