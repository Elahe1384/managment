package datastructures.stacks;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

import java.util.NoSuchElementException;

public class CustomStack<T> implements Queue<T> {
    private CustomLinkedList<T> list;
    private static final int MAX_CAPACITY = 100;

    public CustomStack() {
        list = new CustomLinkedList<>();
    }

    @Override
    public boolean add(Object t) {
        if(list.size() >= MAX_CAPACITY) {
            throw new IllegalArgumentException();
        }
        list.add(t);
        return true;
    }

    @Override
    public boolean offer(Object t) {
        if(list.size() >= MAX_CAPACITY) {
            return false;
        }
        list.add(t);
        return true;
    }

    @Override
    public T remove() {
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.removeLast();
    }

    @Override
    public T poll() {
        if (list.isEmpty()) {
            return null;
        }
        return list.removeLast();
    }

    @Override
    public T element() {
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.getLast();
    }

    @Override
    public T peek() {
        if (list.isEmpty()) {
            return null;
        }
        return list.getLast();
    }

    @Override
    public boolean isEmpty() {
        if (list.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return list.size();
    }

}