package ru.dinz.study.sort.line;

import ru.dinz.Input;
import ru.dinz.Memory;
import ru.dinz.study.sort.QuickSort;

import java.util.ArrayList;
import java.util.List;

public class LineQuickSort extends QuickSort {
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
}
