package ru.dinz.study.sort;

import ru.dinz.Input;
import ru.dinz.Memory;

public abstract class InsertionSort {
    public abstract void execute(Input input, Memory mem);

    static void name() {
        System.out.println("InsertionSort");
    }

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while(j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
        return array;
    }
}
