package ru.dinz.study.sort.column;

import ru.dinz.Input;
import ru.dinz.Memory;
import ru.dinz.study.sort.QuickSort;

import java.util.Arrays;
import java.util.List;

public class ColumnQuickSort extends QuickSort {
    @Override
    public void execute(Input input, Memory mem) {
        List<List<Integer>> lists = mem.getList();
        int[][] array = new int[lists.get(0).size()][lists.size()];
        for (int i = 0; i < lists.get(0).size(); i++) {
            for (int j = 0; j < lists.size(); j++) {
                array[i][j] = lists.get(j).get(i);
            }
        }
        for (int[] ints : array) {
            quickSort(ints, 0, ints.length - 1);
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                lists.get(j).set(i, array[i][j]);
            }
        }
    }
}
