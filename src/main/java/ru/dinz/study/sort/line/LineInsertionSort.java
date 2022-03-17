package ru.dinz.study.sort.line;

import ru.dinz.Input;
import ru.dinz.Memory;
import ru.dinz.study.sort.InsertionSort;

import java.util.List;

public class LineInsertionSort implements InsertionSort {
    @Override
    public void execute(Input input, Memory mem) {
        List<List<Integer>> lists = mem.getList();
        for (List<Integer> list : lists) {
            int[] array = new int[lists.get(0).size()];
            for (int j = 0; j < lists.get(0).size(); j++) {
                array[j] = list.get(j);
            }
            insertionSort(array);
            for (int j = 0; j < lists.get(0).size(); j++) {
                list.set(j, array[j]);
            }
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while(j >= 0 && current < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
    }
}
