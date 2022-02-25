package ru.dinz;

public class ValidateInput implements Input {
    private Output out;
    private Input in;

    public ValidateInput(Output out, Input input) {
        this.out = out;
        this.in = input;
    }

    public ValidateInput(ConsoleInput consoleInput) {
        in = consoleInput;
    }

    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = Integer.parseInt(in.askStr(question));
                invalid = false;
            } catch (NumberFormatException nfe) {
                out.println("Введите число.");
            }
        } while (invalid);
        return value;
    }

    @Override
    public double askDouble(String question, Memory memory) {
        boolean invalid = true;
        double value = -1;
        do {
            try {
                String str = in.askStr(question);
                String[] array = str.split("mem");
                if (array.length == 2) {
                    int numCell = Integer.parseInt(array[1]);
                    if (numCell <= 0 || numCell > memory.size()) {
                        throw new NumberFormatException();
                    }
                    value = memory.get(numCell - 1);
                } else {
                    value = Double.parseDouble(str);
                }
                invalid = false;
            } catch (NumberFormatException nfe) {
                out.println("Введите число или ячейку памяти mem1 .. mem4.");
            }
        } while (invalid);
        return value;
    }
}
