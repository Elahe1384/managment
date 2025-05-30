package datastructures.lists;
import datastructures.interfaces.LinkedList;

import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements LinkedList<T>{
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head, tail;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size==0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean add(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        Node<T> newNode = new Node<>((T) o);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        for (Node<T> node = head; node != null; node = node.next) {
            if (node.data.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> currentNode = head.next;
        Node<T> prevNode = currentNode.prev;
        if (head.data.equals(o)) {
            head = head.next;
            head.prev = null;
            size--;
            return true;
        }
        while (currentNode != null) {
            if (currentNode.data.equals(o)) {
                prevNode.next = currentNode.next;
                currentNode.next.prev = prevNode;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int index) {
        int j = 0;
        for (Node<T> node = head; node != null; node = node.next) {
            if (j == index) {
                return node.data;
            }
            j++;
        }
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        int j = 0;
        for (Node<T> node = head; node != null; node = node.next) {
            if (j == index) {
                node.data = (T) element;
                return node.data;
            }
            j++;
        }
        return null;
    }

    public void addFirst(T t){
        Node<T> newNode = new Node<>(t);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;

    }
    public void addLast(T t){
        Node<T> newNode = new Node<>(t);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    public T removeFirst(){
        if(head == null){
            throw new NoSuchElementException();
        }
        else{
            T data = head.data;
            head = head.next;
            size--;
            return data;
        }
    }
    public T removeLast(){
        if (tail == null) {
            throw new NoSuchElementException();
        }

        T data = tail.data;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
        return data;
    }
    public T getFirst(){
        if(head == null){
            throw new NullPointerException();
        }
        else{
            return head.data;
        }

    }
    public T getLast(){
        if(tail == null){
            throw new NullPointerException();
        }
        else{
            return tail.data;
        }
    }
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

}