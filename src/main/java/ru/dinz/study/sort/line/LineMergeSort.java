package ru.dinz.study.sort.line;

import ru.dinz.Input;
import ru.dinz.Memory;
import ru.dinz.study.sort.MergeSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
