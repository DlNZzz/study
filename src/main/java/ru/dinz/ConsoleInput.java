package ru.dinz;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }

    @Override
    public double askDouble(String question, Memory memory) {
        return Double.parseDouble(askStr(question));
    }

    public static void main(String[] args) {
        System.out.println(Double.parseDouble("2.23"));
    }
}