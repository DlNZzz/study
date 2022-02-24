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
        boolean run = true;
        String question = input.askStr("sin, cos, tg, ctg? ");
        int degrees = input.askInt("Введите угол в градусах ");
        double radians = Math.toRadians(degrees);
        double answer = 0;
        while (run) {
            switch (question) {
                case "sin":
                    answer = Math.sin(radians);
                    run = false;
                    break;
                case "cos":
                    answer = Math.cos(radians);
                    run = false;
                    break;
                case "tg":
                    answer = Math.tan(radians);
                    run = false;
                    break;
                case "ctg":
                    answer = 1 / Math.tan(radians);
                    run = false;
                    break;
                default:
                    question = input.askStr("sin, cos, tg, ctg? ");
                    continue;
            }
        }
        if (answer > 5443746451065122L) {
            out.println("Infinity");
        } else {
            out.println(String.format("%.4f", answer));
        }
        return true;
    }
}
