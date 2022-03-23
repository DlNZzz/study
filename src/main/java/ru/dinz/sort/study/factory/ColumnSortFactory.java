package ru.dinz.sort.study.factory;

import ru.dinz.sort.Output;
import ru.dinz.sort.study.sort.BubbleSort;
import ru.dinz.sort.study.sort.InsertionSort;
import ru.dinz.sort.study.sort.MergeSort;
import ru.dinz.sort.study.sort.QuickSort;
import ru.dinz.sort.study.sort.column.ColumnBubbleSort;
import ru.dinz.sort.study.sort.column.ColumnInsertionSort;
import ru.dinz.sort.study.sort.column.ColumnMergeSort;
import ru.dinz.sort.study.sort.column.ColumnQuickSort;

public class ColumnSortFactory extends SortFactory {

    private Output out;

    public ColumnSortFactory(Output out) {
        this.out = out;
    }

    @Override
    public BubbleSort createBubbleSort() {
        return new ColumnBubbleSort();
    }

    @Override
    public InsertionSort createInsertionSort() {
        return new ColumnInsertionSort();
    }

    @Override
    public MergeSort createMergeSort() {
        return new ColumnMergeSort();
    }

    @Override
    public QuickSort createQuickSort() {
        return new ColumnQuickSort();
    }

    @Override
    public String getName() {
        return "Сортировка по столбцам.";
    }
}
