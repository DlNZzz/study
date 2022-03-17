package ru.dinz.study.factory;

import ru.dinz.study.sort.BubbleSort;
import ru.dinz.study.sort.InsertionSort;
import ru.dinz.study.sort.MergeSort;
import ru.dinz.study.sort.QuickSort;

public abstract class SortFactory {
    public abstract BubbleSort createBubbleSort();

    public abstract InsertionSort createInsertionSort();

    public abstract MergeSort createMergeSort();

    public abstract QuickSort createQuickSort();

    public abstract String getName();
}
