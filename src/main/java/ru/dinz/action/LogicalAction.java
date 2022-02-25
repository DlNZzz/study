package ru.dinz.action;

import ru.dinz.Input;
import ru.dinz.Memory;
import ru.dinz.Output;
import ru.dinz.UserAction;

public class LogicalAction implements UserAction {

    private final Output out;

    public LogicalAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Побитовые логические вычисления";
    }

    @Override
    public boolean execute(Input input, Memory mem) {
        boolean run = true;
        int numOne = input.askInt("Введите первую цифру ");
        String sign = input.askStr("Введите оперцию 1. И, 2. ИЛИ, 3. НЕ, 4. ИСКЛЮЧАЮЩЕЕ ИЛИ");
        int numTwo = 0;
        if (!"3".equals(sign)) {
            numTwo = input.askInt("Введите вторую цифру ");
        }
        int answer = 0;
        while (run) {
            run = false;
            switch (sign) {
                case "1" -> answer = numOne & numTwo;
                case "2" -> answer = numOne | numTwo;
                case "3" -> answer = ~numOne;
                case "4" -> answer = numOne ^ numTwo;
                default -> {
                    sign = input.askStr("Введите оперцию 1. И, 2. ИЛИ, 3. НЕ, 4. ИСКЛЮЧАЮЩЕЕ ИЛИ");
                    run = true;
                }
            }
        }
        out.println(answer);
        return true;
    }
}
