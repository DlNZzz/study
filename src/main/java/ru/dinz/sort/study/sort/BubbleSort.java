package ru.dinz.sort.study.sort;

import ru.dinz.sort.Input;
import ru.dinz.sort.Memory;

public abstract class BubbleSort {

    public abstract void execute(Input input, Memory mem);

    static void name() {
        System.out.println("BubbleSort");
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = array.length - 1 ; i > 0 ; i--) {
            for (int j = 0 ; j < i ; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }
}
