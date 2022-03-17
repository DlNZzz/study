package ru.dinz.study.factory;

import ru.dinz.Output;
import ru.dinz.study.sort.BubbleSort;
import ru.dinz.study.sort.InsertionSort;
import ru.dinz.study.sort.MergeSort;
import ru.dinz.study.sort.QuickSort;
import ru.dinz.study.sort.column.ColumnBubbleSort;
import ru.dinz.study.sort.column.ColumnInsertionSort;
import ru.dinz.study.sort.column.ColumnMergeSort;
import ru.dinz.study.sort.column.ColumnQuickSort;

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
