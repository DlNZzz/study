package ru.dinz;

public interface Memory {
    void init();

    boolean add(int pos, double el);

    double get(int pos);

    double size();
}
