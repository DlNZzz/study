package ru.dinz.action;

import ru.dinz.Input;
import ru.dinz.Memory;
import ru.dinz.Output;
import ru.dinz.UserAction;

public class TrigonometryAction implements UserAction {

    private final Output out;

    public TrigonometryAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Тригонометрические операции";
    }

    @Override
    public boolean execute(Input input, Memory mem) {
        return true;
    }
}
