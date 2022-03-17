package ru.dinz;

import java.util.List;

public interface Memory {

    void init();

    void init(List<List<Integer>> list);

    List<List<Integer>> getList();
}
