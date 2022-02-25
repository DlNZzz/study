package ru.dinz;

public interface Input {
    String askStr(String question);

    int askInt(String question);

    double askDouble(String question, Memory memory);
}