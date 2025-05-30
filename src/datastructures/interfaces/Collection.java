package datastructures.interfaces;

public interface Collection<T> {
    int size();
    boolean isEmpty();
    boolean add(Object o);
    boolean contains(Object o);
    boolean remove(Object o);
}