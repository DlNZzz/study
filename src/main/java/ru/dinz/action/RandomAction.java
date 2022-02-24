package ru.dinz.action;

import ru.dinz.Input;
import ru.dinz.Memory;
import ru.dinz.Output;
import ru.dinz.UserAction;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RandomAction implements UserAction {

    private final Output out;

    public RandomAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Сгенерировать псевдослучайное число в заданном \n" +
                "диапазоне";
    }

    @Override
    public boolean execute(Input input, Memory mem) {
        return true;
    }
}
