package ru.dinz.sort.study.sort.line;

import ru.dinz.sort.Input;
import ru.dinz.sort.Memory;
import ru.dinz.sort.study.sort.MergeSort;

import java.util.ArrayList;
import java.util.List;

public class LineMergeSort extends MergeSort {
    @Override
    public void execute(Input input, Memory mem) {
        List<List<Integer>> lists = mem.getList();
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            int[] array = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                array[j] = list.get(j);
            }
            array = mergesort(array);
            List<Integer> list1 = new ArrayList<>();
            for (int k : array) {
                list1.add(k);
            }
            lists.set(i, list1);
        }
    }
}
