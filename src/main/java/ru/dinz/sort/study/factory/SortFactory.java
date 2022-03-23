package ru.dinz.sort.study.factory;

import ru.dinz.sort.study.sort.BubbleSort;
import ru.dinz.sort.study.sort.InsertionSort;
import ru.dinz.sort.study.sort.MergeSort;
import ru.dinz.sort.study.sort.QuickSort;

public abstract class SortFactory {
    public abstract BubbleSort createBubbleSort();

    public abstract InsertionSort createInsertionSort();

    public abstract MergeSort createMergeSort();

    public abstract QuickSort createQuickSort();

    public abstract String getName();
}
