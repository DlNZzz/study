package ru.dinz.study.sort;

import ru.dinz.Input;
import ru.dinz.Memory;

public interface MergeSort {
    void execute(Input input, Memory mem);

    static void name() {
        System.out.println("MergeSort");
    }
}
