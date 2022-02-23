package ru.dinz;

public interface UserAction {
    String name();

    boolean execute(Input input, Memory mem);
}
