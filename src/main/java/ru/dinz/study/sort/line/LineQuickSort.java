package ru.dinz.study.sort.line;

import ru.dinz.Input;
import ru.dinz.Memory;
import ru.dinz.study.sort.QuickSort;

import java.util.ArrayList;
import java.util.List;

public class LineQuickSort implements QuickSort {
    @Override
    public void execute(Input input, Memory mem) {
        List<List<Integer>> lists = mem.getList();
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            int[] array = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                array[j] = list.get(j);
            }
            quickSort(array, 0, array.length - 1);
            List<Integer> list1 = new ArrayList<>();
            for (int k : array) {
                list1.add(k);
            }
            lists.set(i, list1);
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        int opora = array[middle];
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }
            while (array[j] > opora) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(array, low, j);
        }
        if (high > i) {
            quickSort(array, i, high);
        }
    }
}
