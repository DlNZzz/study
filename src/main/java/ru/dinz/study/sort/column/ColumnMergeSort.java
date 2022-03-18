package ru.dinz.study.sort.column;

import ru.dinz.Input;
import ru.dinz.Memory;
import ru.dinz.study.sort.MergeSort;

import java.util.Arrays;
import java.util.List;

public class ColumnMergeSort extends MergeSort {
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
            array[i] = mergesort(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                lists.get(j).set(i, array[i][j]);
            }
        }
    }

    public static int[] mergesort(int[] array) {
        int[] buffer1 = Arrays.copyOf(array, array.length);
        int[] buffer2 = new int[array.length];
        int[] result = mergesortInner(buffer1, buffer2, 0, array.length);
        return result;
    }

    public static int[] mergesortInner(int[] buffer1, int[] buffer2,
                                       int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergesortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergesortInner(buffer1, buffer2, middle, endIndex);
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}
