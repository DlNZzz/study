package ru.dinz;

public class MemoryCalculator implements Memory {

    private double[] array;

    @Override
    public void init() {
        array = new double[4];
    }

    @Override
    public boolean add(int pos, double el) {
        boolean isAdd = false;
        if (pos >= 0 && size() >= pos) {
            array[pos] = el;
            isAdd = true;
        }
        return isAdd;
    }

    @Override
    public double get(int pos) {
        return array[pos];
    }

    @Override
    public double size() {
        return array.length;
    }
}
