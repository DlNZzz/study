package ru.dinz.action;

import ru.dinz.Input;
import ru.dinz.Memory;
import ru.dinz.Output;
import ru.dinz.UserAction;

public class ArithmeticAction implements UserAction {

    private final Output out;

    public ArithmeticAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Арифметические вычисления";
    }

    @Override
    public boolean execute(Input input, Memory mem) {
        boolean run = true;
        double numOne = input.askDouble("Введите первую цифру ", mem);
        String sign = input.askStr("Введите знак ");
        double numTwo = input.askDouble("Введите вторую цифру ", mem);
        double answer = 0;
        while (run) {
            run = false;
            switch (sign) {
                case "+" -> answer = numOne + numTwo;
                case "-" -> answer = numOne - numTwo;
                case "*" -> answer = numOne * numTwo;
                case "/" -> {
                    if (numTwo == 0) {
                        out.println("Вы ввели неверный второй аргумент");
                    } else {
                        answer = numOne / numTwo;
                    }
                }
                default -> {
                    sign = input.askStr("Введите знак ");
                    run = true;
                }
            }

        }
        out.println(answer);
        return true;
    }
}
