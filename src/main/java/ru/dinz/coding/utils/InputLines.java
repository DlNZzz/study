package ru.dinz.coding.utils;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputLines {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final String alphabat = "qwertyuiopasdfghjklzxcvbnm";

    public static String getText() {
        Pattern pattern = Pattern.compile("[a-z ]+");
        while (true) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                return line;
            } else {
                System.out.println("Строка должна состоять только из маленьких английский букв");
            }
        }
    }

    public static int returnInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число, попробуйте еще раз!");
            }
        }
    }

    public static String autoCreateKey(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(alphabat.charAt(random.nextInt(26)));
        }
        return stringBuilder.toString();
    }
}
