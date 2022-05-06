package ru.dinz.array;

import java.util.*;

public class SinglyLinkedList<T> implements List<T> {

    private Node<T> head;
    //private Node<T> last;
    private int size;

    private final Comparator<? super T> comparator;

    public SinglyLinkedList(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }
    
    @Override
    public void add(T value) {
        size++;
        Node<T> newNode = new Node<>(value, null);
        if (head == null) {
            head = newNode;
            //last = head;
            return;
        }
        Node<T> tail = head;
        if (comparator.compare(head.value, value) > 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        while (tail.next != null) {
            if (comparator.compare(tail.next.value, value) > 0) {
                Node<T> temp = tail.next;
                tail.next = newNode;
                newNode.next = temp;
                return;
            }
            tail = tail.next;
        }
        tail.next = newNode;
        //last = tail.next;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> element = head;
        for (int i = 0; i <= index; i++) {
            if (index == i) {
                return element.value;
            } else {
                element = element.next;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    private T unlink(Node<T> prev, Node<T> x) {
        final T element = x.value;
        final Node<T> next = x.next;
        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
        }
        if (next != null) {
            x.next = null;
        }
        x.value = null;
        size--;
        return element;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> prev = null;
        if (o == null) {
            for (Node<T> x = head; x != null; x = x.next) {
                if (x.value == null) {
                    unlink(prev, x);
                    return true;
                }
                prev = x;
            }
        } else {
            for (Node<T> x = head; x != null; x = x.next) {
                if (o.equals(x.value)) {
                    unlink(prev, x);
                    return true;
                }
                prev = x;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        T element = get(index);
        if (remove(get(index))) {
            return element;
        }
        return null;
    }

    @Override
    public boolean addAll(List<? extends T> c) {
        for (T value : c) {
            add(value);
        }
        return true;
    }

    @Override
    public List<T> subList(int from, int before) {
        Objects.checkIndex(before, size);
        List<T> list = new SinglyLinkedList<>(comparator);
        Objects.checkIndex(from, before);
        for (int i = from; i < before; i++) {
            list.add(remove(from));
        }
        return list;
    }

    @Override
    public java.util.List<List<T>> division(int div) {
        java.util.List<List<T>> list = new ArrayList<>();
        int countList = (int) Math.ceil((double) size / div);
        for (int i = 0; i < countList; i++) {
            list.add(new SinglyLinkedList<T>(comparator));
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < list.size(); j++) {
                for (int k = 0; k < div; k++) {
                    if (size > 0) {
                        list.get(j).add(get(0));
                        remove(0);
                    }
                }
            }
        }
        return list;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
