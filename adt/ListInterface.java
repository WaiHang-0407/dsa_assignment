package adt;

public interface ListInterface<T> extends Iterable<T> {
    void add(T element);
    T get(int index);
    void remove(int index);
    int size();
    boolean isEmpty();
    void clear();
}
