package ru.dinz.array;

public interface List<T> extends Iterable<T> {

    void add(T value);

    T get(int index);

    boolean remove(Object o);

    int size();

    List<T> subList(int fromIndex, int toIndex);

    T remove(int index);

    boolean addAll(List<? extends T> c);

    java.util.List<List<T>> division(int div);
}

