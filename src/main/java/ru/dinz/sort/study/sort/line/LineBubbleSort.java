package ru.dinz.sort.study.sort.line;

import ru.dinz.sort.Input;
import ru.dinz.sort.Memory;
import ru.dinz.sort.study.sort.BubbleSort;

import java.util.List;

public class LineBubbleSort extends BubbleSort {

    @Override
    public void execute(Input input, Memory mem) {
        List<List<Integer>> lists = mem.getList();
        for (List<Integer> list : lists) {
            int[] array = new int[lists.get(0).size()];
            for (int j = 0; j < lists.get(0).size(); j++) {
                array[j] = list.get(j);
            }
            bubbleSort(array);
            for (int j = 0; j < lists.get(0).size(); j++) {
                list.set(j, array[j]);
            }
        }
    }
}
