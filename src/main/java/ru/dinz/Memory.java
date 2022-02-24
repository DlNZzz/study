package ru.dinz;

public interface Memory {
    void init();
    void add(int pos, int el);
    int get(int pos);
    int size();
}
