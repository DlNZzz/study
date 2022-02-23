package ru.dinz.action;

import ru.dinz.Input;
import ru.dinz.Memory;
import ru.dinz.Output;
import ru.dinz.UserAction;

public class ConversionAction implements UserAction {

    private final Output out;

    public ConversionAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Конвертация числа из заданной \n" +
                "системы счисления в другую";
    }

    @Override
    public boolean execute(Input input, Memory mem) {
        return true;
    }
}
