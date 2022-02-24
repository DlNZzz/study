package ru.dinz;

public class MemoryCalculator implements Memory {

    private int[] a;

    @Override
    public void init() {
        a = new int[4];
    }

    @Override
    public void add(int pos, int el) {

    }

    @Override
    public int get(int pos) {
        return -1;
    }

    @Override
    public int size() {
        return a.length;
    }
}
