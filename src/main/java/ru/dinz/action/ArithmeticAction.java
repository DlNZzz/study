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
        int numOne = input.askInt("Введите первую цифру ");
        String sign = input.askStr("Введите знак ");
        int numTwo = input.askInt("Введите вторую цифру ");
        while (run) {
            double answer = 0;
            switch (sign) {
                case "+":
                    answer = numOne + numTwo;
                    run = false;
                    break;
                case "-":
                    answer = numOne - numTwo;
                    run = false;
                    break;
                case "*":
                    answer = numOne * numTwo;
                    run = false;
                    break;
                case "/":
                    if (numTwo == 0) {
                        out.println("Вы ввели неверный второй аргумент");
                    } else {
                        answer = (double) numOne / numTwo;
                    }
                    break;
                default:
                    sign = input.askStr("Введите знак ");
                    continue;
            }
            out.println(answer);
        }
        return true;
    }
}
