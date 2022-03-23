package ru.dinz.sort.study.factory;

import ru.dinz.sort.Output;
import ru.dinz.sort.study.sort.BubbleSort;
import ru.dinz.sort.study.sort.InsertionSort;
import ru.dinz.sort.study.sort.MergeSort;
import ru.dinz.sort.study.sort.QuickSort;
import ru.dinz.sort.study.sort.line.LineBubbleSort;
import ru.dinz.sort.study.sort.line.LineInsertionSort;
import ru.dinz.sort.study.sort.line.LineMergeSort;
import ru.dinz.sort.study.sort.line.LineQuickSort;

public class LineSortFactory extends SortFactory {

    private Output out;

    public LineSortFactory(Output out) {
        this.out = out;
    }

    @Override
    public BubbleSort createBubbleSort() {
        return new LineBubbleSort();
    }

    @Override
    public InsertionSort createInsertionSort() {
        return new LineInsertionSort();
    }

    @Override
    public MergeSort createMergeSort() {
        return new LineMergeSort();
    }

    @Override
    public QuickSort createQuickSort() {
        return new LineQuickSort();
    }

    @Override
    public String getName() {
        return "Сортировка по строкам.";
    }
}
