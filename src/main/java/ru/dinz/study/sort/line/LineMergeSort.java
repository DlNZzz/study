package ru.dinz.study.sort.line;

import ru.dinz.Input;
import ru.dinz.Memory;
import ru.dinz.study.sort.MergeSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineMergeSort implements MergeSort {
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

    public static int[] mergesort(int[] array) {
        int[] buffer1 = Arrays.copyOf(array, array.length);
        int[] buffer2 = new int[array.length];
        return mergesortInner(buffer1, buffer2, 0, array.length);
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
