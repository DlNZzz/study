package ru.dinz.action;

import ru.dinz.Input;
import ru.dinz.Memory;
import ru.dinz.Output;
import ru.dinz.UserAction;

public class MemoryAction implements UserAction {

    private final Output out;

    public MemoryAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Сохранить введённое значение в одну из четырёх\n" +
                "ячеек памяти";
    }

    @Override
    public boolean execute(Input input, Memory mem) {
        int sz = input.askInt("Введите номер ячейки 0 .. " + mem.size());
        int s = input.askInt("Введите число которое хотитете сохранить");
        mem.add(sz, s);
        return true;
    }
}
