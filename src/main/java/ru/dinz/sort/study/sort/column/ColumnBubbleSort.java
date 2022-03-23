package ru.dinz.sort.study.sort.column;

import ru.dinz.sort.Input;
import ru.dinz.sort.Memory;
import ru.dinz.sort.study.sort.BubbleSort;
import java.util.List;

public class ColumnBubbleSort extends BubbleSort {

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
            array[i] = bubbleSort(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                lists.get(j).set(i, array[i][j]);
            }
        }
    }
}
