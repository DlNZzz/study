package ru.dinz.action;

import ru.dinz.Input;
import ru.dinz.Memory;
import ru.dinz.Output;
import ru.dinz.UserAction;

public class ExitAction implements UserAction {

    @Override
    public String name() {
        return "Выход";
    }

    @Override
    public boolean execute(Input input, Memory mem) {
        return false;
    }
}
