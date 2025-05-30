package datastructures.queues;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

import java.util.NoSuchElementException;

public class CustomQueue<T> implements Queue<T> {
    private static final int MAX_CAPACITY = 100;
    private CustomLinkedList<T> list;

    public CustomQueue() {
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
        if(list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.removeFirst();
    }

    @Override
    public T poll() {
        if(list.isEmpty()) {
            return null;
        }
        return list.getFirst();
    }

    @Override
    public T element() {
        if(list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.getFirst();
    }

    @Override
    public T peek() {
        if(list.isEmpty()) {
            return null;
        }
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        if(list.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return list.size();
    }

}