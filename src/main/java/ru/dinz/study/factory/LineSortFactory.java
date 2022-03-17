package ru.dinz.study.factory;

import ru.dinz.Output;
import ru.dinz.study.sort.BubbleSort;
import ru.dinz.study.sort.InsertionSort;
import ru.dinz.study.sort.MergeSort;
import ru.dinz.study.sort.QuickSort;
import ru.dinz.study.sort.line.LineBubbleSort;
import ru.dinz.study.sort.line.LineInsertionSort;
import ru.dinz.study.sort.line.LineMergeSort;
import ru.dinz.study.sort.line.LineQuickSort;

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
