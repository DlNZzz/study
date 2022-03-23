package ru.dinz.sort;

import java.util.ArrayList;
import java.util.List;

public class ArrayMemory implements Memory {

    private List<List<Integer>> list;

    @Override
    public void init() {
        list = new ArrayList<>();
    }

    @Override
    public void init(List<List<Integer>> list) {
        this.list = list;
    }

    @Override
    public List<List<Integer>> getList() {
        return list;
    }
}
