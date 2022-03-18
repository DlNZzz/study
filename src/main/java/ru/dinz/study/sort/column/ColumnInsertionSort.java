package ru.dinz.study.sort.column;

import ru.dinz.Input;
import ru.dinz.Memory;
import ru.dinz.study.sort.InsertionSort;
import java.util.List;

public class ColumnInsertionSort extends InsertionSort {
    @Override
    public void execute(Input input, Memory mem) {
        List<List<Integer>> lists = mem.getList();
        int[][] array = new int[lists.get(0).size()][lists.size()];
        for (int i = 0; i < lists.get(0).size(); i++) {
            for (int j = 0; j < lists.size(); j++) {
                array[i][j] = lists.get(j).get(i);
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = insertionSort(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                lists.get(j).set(i, array[i][j]);
            }
        }
    }
}
